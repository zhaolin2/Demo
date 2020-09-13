package com.javase.thread.lock;

import com.sun.corba.se.impl.orbutil.concurrent.Sync;

import java.awt.geom.QuadCurve2D;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author zl
 * aqs 思想：被请求的共享资源空闲 就把当前线程设置为有效线程  并且把资源设置为锁定
 * 如果资源被锁定 那么就加入到CLH队列中
 * CLH队列是一个虚拟的双向队列(不存在实例 只存在节点之间的关系)
 * 把请求的线程封装为队列中的一个节点来进行锁的分配
 * <p>
 * JDK实现：{@link java.util.concurrent.locks.ReentrantLock}
 * {@link java.util.concurrent.CountDownLatch}
 * {@link java.util.concurrent.Semaphore}
 * {@link java.util.concurrent.CyclicBarrier}
 *
 * 实现的是ReentrantLock的公平 可重入锁
 */
public class AqsLock implements Lock {

    Sync sync;

    public AqsLock() {
        sync = new Sync();
    }

    @Override
    public void lock() {
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit timeUnit) throws InterruptedException {

        return sync.tryAcquireNanos(1,timeUnit.toNanos(time));
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return sync.newCondition();
    }

    /**
     * 使用内部类的方式来实现aqs 外部使用lock的形式来展示
     */
    static final class Sync extends AbstractQueuedSynchronizer {

        public Sync() {
        }

        /**
         * 独占+公平锁方式来实现
         *
         * @param acquires
         * @return
         */
        @Override
        final protected boolean tryAcquire(int acquires) {

            assert acquires>0;
            Thread currentThread = Thread.currentThread();
            int state = getState();
            //公平锁
            if (state == 0) {
                if (!hasQueuedPredecessors() &&
                        compareAndSetState(0, acquires)) {
                    setExclusiveOwnerThread(currentThread);
                    return true;
                }
            } else if (currentThread == getExclusiveOwnerThread()) {
                int nextState = state + acquires;
                setState(nextState);
            }
            return false;
        }

        @Override
        final protected boolean tryRelease(int releases) {
            boolean free=false;

            int state=getState()-releases;
            if (Thread.currentThread()!=getExclusiveOwnerThread()){
                throw new IllegalMonitorStateException("线程未尺有锁 无法释放");
            }
            if (state==0){
                free=true;
                setExclusiveOwnerThread(null);
            }
            setState(state);
            return free;
        }

        @Override
        final protected boolean tryReleaseShared(int arg) {
            return super.tryReleaseShared(arg);
        }

        final ConditionObject newCondition() {
            return new ConditionObject();
        }

    }
}
