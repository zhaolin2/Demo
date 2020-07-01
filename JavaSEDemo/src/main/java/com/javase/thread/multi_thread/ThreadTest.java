package com.javase.thread.multi_thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static sun.net.InetAddressCachePolicy.get;

public class ThreadTest {
    public static void main(String[] args) {
        // 无限大小线程池 jvm自动回收
        //分别对应了这个接口的几类实现
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
//        Executors.newFixedThreadPool(2);
//        Executors.newScheduledThreadPool(5);
//        Executors.newFixedThreadPool(2);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newCachedThreadPool.execute(new Runnable() {

                @Override
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }
                    System.out.println(Thread.currentThread().getName() + ",i:" + temp);

                }
            });
        }

        AtomicInteger i=new AtomicInteger(1);
        i.incrementAndGet();
    }
}
