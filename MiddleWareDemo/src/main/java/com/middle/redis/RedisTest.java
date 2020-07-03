package com.middle.redis;


import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * @Description: 基于redis的分布式锁
 * @Author: 敖丙
 * @date: 2020-04-12
 **/
public class RedisTest {

    private static volatile Integer inventory = 1;
    private static final int NUM = 1000;
    private static LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
    volatile static CountDownLatch countDownLatch = new CountDownLatch(10);
    static CyclicBarrier cyclicBarrier = new CyclicBarrier(5);

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i=0;i<10;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    try {
                        System.out.println("AAA");
                        cyclicBarrier.await();
//                        cyclicBarrier.
                        System.out.println("BBB");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }


//            ThreadPoolExecutor threadPoolExecutor =
//                    new ThreadPoolExecutor(inventory, inventory, 10L, SECONDS, linkedBlockingQueue);
//            long start = System.currentTimeMillis();
//            Config config = new Config();
//            config.useSingleServer().setAddress("redis://127.0.0.1:6379");
//            final RedissonClient client = Redisson.create(config);
//            final RLock lock = client.getLock("lock1");
//
//            for (int i = 0; i <= NUM; i++) {
//            threadPoolExecutor.execute(new Runnable() {
//                public void run() {
//                    lock.lock();
//                    inventory--;
//                    System.out.println(inventory);
//                    lock.unlock();
//                }
//            });
//        }
//        long end = System.currentTimeMillis();
//        System.out.println("执行线程数:" + NUM + "   总耗时:" + (end - start) + "  库存数为:" + inventory);
    }


}
