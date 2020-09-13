package com.javase.thread.lock;

import com.javase.thread.threadPool.MyRunnable;

import java.util.concurrent.locks.Lock;

/**
 * @author zl
 */
public class LockDemo {

    public static void main(String[] args) {
        Lock lock = new AqsLock();
        MyRunnable lockTest = new MyRunnable("lockTest");
        for (int i=0;i<10;i++){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        lock.lock();
                        try {
                            lockTest.run();
                        }catch (Exception e){
                            e.printStackTrace();
                        }finally {
                            lock.unlock();
                        }
                    }
                }).start();
        }
    }
}
