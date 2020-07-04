package com.javase.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zl
 */
public class ThreadPoolExcutorDemo {
    private static final int CORE_POOL_SIZE=5;
    private static final int MAX_POOL_SIZE=10;
    private static final int QUEUE_SIZE=5;
    private static final int KEEP_ALIVE_TIME=5;

    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                CORE_POOL_SIZE,
                MAX_POOL_SIZE,
                KEEP_ALIVE_TIME,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(QUEUE_SIZE),
                //会使用调用线程来执行这个runnable
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i=0;i<20; i++){
            MyRunnable worker = new MyRunnable("" + i);
            poolExecutor.execute(worker);

        }

        poolExecutor.shutdown();
        while (!poolExecutor.isTerminated()){

        }
        System.out.println("Thread Shut down");
    }

    public static class InnerThreadFactory implements ThreadFactory{

        private AtomicInteger atomicInteger = new AtomicInteger();

        private boolean isDaemon;

        public InnerThreadFactory(){
            this.isDaemon=false;
        }
        public InnerThreadFactory(boolean isDaemon){
            this.isDaemon = isDaemon;
        }

        @Override
        public Thread newThread(Runnable r) {
            atomicInteger.incrementAndGet();
            Thread thread = new Thread(String.valueOf(atomicInteger.get()));
            thread.setName("PoolDemo");
            thread.setDaemon(isDaemon);
            return thread;
        }
    }
}
