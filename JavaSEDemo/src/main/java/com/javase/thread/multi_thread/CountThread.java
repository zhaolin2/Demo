package com.javase.thread.multi_thread;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

public class CountThread {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                reentrantLock.lock();
                System.out.println("this is the first thread!");
                reentrantLock.unlock();
            }
        });
        thread.setName("threa1");
        thread.start();

//        Thread.yield();
//        LockSupport.park(thread);

    }
}
