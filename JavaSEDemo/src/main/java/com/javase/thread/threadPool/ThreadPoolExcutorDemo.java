package com.javase.thread.threadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zl
 * https://mrbird.cc/Java-Thread-Pool.html
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
                new InnerThreadFactory("ThreadPoolDemo"),
                //会使用调用线程来执行这个runnable
                new ThreadPoolExecutor.CallerRunsPolicy()
        );

        for (int i=0;i<20; i++){
            MyRunnable worker = new MyRunnable("" + i);
            poolExecutor.execute(worker);

        }



//        poolExecutor.shutdown();
        while (!poolExecutor.isTerminated()){
            if (poolExecutor.getActiveCount()==0){
                poolExecutor.shutdown();
            }
            System.out.println(poolExecutor.getActiveCount());
        }
        System.out.println("Thread Shut down");
    }

    public static class InnerThreadFactory implements ThreadFactory{

        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final ThreadGroup group;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final String namePrefix;

        private boolean isDaemon;

        public InnerThreadFactory(){
            SecurityManager s = System.getSecurityManager();
            group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
            this.namePrefix = "pool-Demo" +
                    poolNumber.getAndIncrement() +
                    "-thread-";
        }
        public InnerThreadFactory(String namePrefix){

            SecurityManager s = System.getSecurityManager();
             group = (s != null) ? s.getThreadGroup() :
                    Thread.currentThread().getThreadGroup();
             this.namePrefix = namePrefix +"-"+
                    poolNumber.getAndIncrement() +
                    "-thread-";

        }

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(group, r,
                    namePrefix + threadNumber.getAndIncrement(),
                    0);
            if (t.isDaemon()) {
                t.setDaemon(false);
            }
            if (t.getPriority() != Thread.NORM_PRIORITY) {
                t.setPriority(Thread.NORM_PRIORITY);
            }
            return t;
        }
    }
}
