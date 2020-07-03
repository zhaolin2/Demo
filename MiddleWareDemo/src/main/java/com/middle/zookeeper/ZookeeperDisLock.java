package com.middle.zookeeper;

import io.netty.util.internal.StringUtil;
import org.I0Itec.zkclient.IZkDataListener;
import org.I0Itec.zkclient.ZkClient;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zl
 */
public class ZookeeperDisLock implements Lock {

    private Condition condition=new ReentrantLock().newCondition();

//    private Object condition=new Object();

    private static final String IP_PORT = "127.0.0.1:2181";
    private static final String Z_NODE = "/LOCK";

    ThreadLocal<String> path=ThreadLocal.withInitial(()->{
        return "";
    });

    ThreadLocal<String> beforePath=ThreadLocal.withInitial(()->{
        return "";
    });
//    private volatile String beforePath;
//    private volatile String path;

    private ZkClient zkClient = new ZkClient(IP_PORT);

    public ZookeeperDisLock() {
        if (!zkClient.exists(Z_NODE)) {
            zkClient.createPersistent(Z_NODE);
        }
    }

    @Override
    public void lock() {
        if (tryLock()) {
            System.out.println(Thread.currentThread().getName()+"获得锁");
        } else {
            // 尝试加锁
            // 进入等待 监听
            waitForLock();
            // 再次尝试
            lock();
        }
    }

    private void waitForLock() {
        IZkDataListener listener = new IZkDataListener() {
            @Override
            public void handleDataChange(String s, Object o) throws Exception {
            }

            @Override
            public void handleDataDeleted(String s) throws Exception {
                System.out.println(Thread.currentThread().getName() + " :监听到节点删除事件！---------------------------");
                condition.signalAll();
//                cdl.countDown();
            }
        };

        // 监听
        this.zkClient.subscribeDataChanges(beforePath.get(), listener);
        if (zkClient.exists(beforePath.get())) {
            try {
//                System.out.println(Thread.currentThread().getName()+" 加锁失败 等待");
                Thread.sleep(1000);
                condition.await();
//                cdl.await();
            } catch (InterruptedException | IllegalMonitorStateException e) {
//                e.printStackTrace();
            }
        }
        // 释放监听
        zkClient.unsubscribeDataChanges(beforePath.get(), listener);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public synchronized boolean tryLock() {
        // 第一次就进来创建自己的临时节点
        if (StringUtil.isNullOrEmpty(path.get())) {
            path.set(zkClient.createEphemeralSequential(Z_NODE + "/", "lock"));
        }
        List<String> children = zkClient.getChildren(Z_NODE);

        // 对节点排序
        Collections.sort(children);

        // 当前的是最小节点就返回加锁成功
        if (path.get().equals(Z_NODE + "/" + children.get(0))) {
//            System.out.println(Thread.currentThread().getName()+" 我是最小的 获取锁 ");
            System.out.println(path.get()+"---"+(Z_NODE + "/" + children.get(0)));
            return true;
        } else {
            // 不是最小节点 就找到自己的前一个 依次类推 释放也是一样
            int i = Collections.binarySearch(children, path.get().substring(Z_NODE.length() + 1));
            beforePath.set(Z_NODE + "/" + children.get(i - 1));
//            System.out.println(Thread.currentThread().getName()+" tryLock失败"+ " beforePath为"+beforePath.get());
        }
        return false;

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        zkClient.delete(path.get());
    }

    @Override
    public Condition newCondition() {
        return null;
    }

    public static void main(String[] args) {

    }
}
