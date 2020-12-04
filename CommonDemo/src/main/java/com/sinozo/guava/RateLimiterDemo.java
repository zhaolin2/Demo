package com.sinozo.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author zl
 */
public class RateLimiterDemo {

    // 1秒钟产生0.5张令牌
    private static final  RateLimiter limiter = RateLimiter.create(0.5);

    public static void main(String[] args) throws InterruptedException {
        RateLimiterDemo rateLimiterDemo = new RateLimiterDemo();
//        Thread.sleep(10000);
//        rateLimiterDemo.baseDemo();

        IntStream.range(0, 100).forEach(i -> {

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i + "---" + limiter.acquire());

                });

//        IntStream.range(0,5).forEach((i)->{
//
//        });
//        rateLimiterDemo.oneTimeAcquire();
//
//        rateLimiterDemo.acquireTimeWait();



    }

    /**
     *表示每次消耗一次令牌  当前线程会进行阻塞
     */
    private static void testLimiter(){
        //表示消耗一个令牌
        double acquire = limiter.acquire();
        System.out.println(Thread.currentThread().getName() + " waiting "+acquire);
    }


    public void baseDemo() {
        ExecutorService service = Executors.newFixedThreadPool(5);
        IntStream.range(0, 5).forEach(i -> service.submit(RateLimiterDemo::testLimiter));
        service.shutdown();

    }

    /**
     *  每次可以获得多个令牌  数量通过acquire()来指定
     *  每次是可以超出来进行获取的   下一次请求需要等待令牌补齐
     */
    private void oneTimeAcquire() {
        //表示每秒生产一个  每次消耗多个
        RateLimiter limiter = RateLimiter.create(1);
        System.out.println(limiter.acquire(4));
        System.out.println(limiter.acquire(3));
        System.out.println(limiter.acquire(2));
        System.out.println(limiter.acquire(1));
    }

    /**
     * 令牌的等待时间超出则不等待
     */
    private void acquireTimeWait(){
        RateLimiter limiter = RateLimiter.create(1);
        System.out.println(limiter.acquire(3));
        System.out.println(limiter.tryAcquire(1, 2, TimeUnit.SECONDS));
    }
}
