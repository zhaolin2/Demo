package com.middle.zookeeper;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zl
 */
public class ZooDisTest {

    private static final ReentrantLock LOCK=new ReentrantLock();
    static int inven=1;
    private static final int Num=10;

    private static final CountDownLatch COUNT_DOWN_LATCH=new CountDownLatch(10);

    private ZookeeperDisLock zookeeperDisLock =new ZookeeperDisLock();

    public static void main(String[] args) {

        ZooDisTest zooDisTest = new ZooDisTest();
        try {
            for (int i = 0; i < Num; i++) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            zooDisTest.zookeeperDisLock.lock();
                            Thread.sleep(1000);
                            if (inven > 0) {
                                inven--;
                            }
                            System.out.println(inven);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        } finally {
                            zooDisTest.zookeeperDisLock.unlock();
                            System.out.println(Thread.currentThread().getName()+" 释放锁");
                        }
                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
