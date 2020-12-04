package com.sinozo;

import com.google.common.util.concurrent.*;
import io.netty.util.concurrent.DefaultEventExecutor;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.FutureListener;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.*;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/23
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //阻塞操作
        long l = System.currentTimeMillis();

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("执行耗时操作...");
                Thread.sleep(3000);
                return 100;
            }

        });
        System.out.println("计算结果:" + future.get());
        System.out.println("主线程运算耗时:" + (System.currentTimeMillis() - l) + " ms");

        //netty添加监听器
        DefaultEventExecutorGroup eventExecutors = new DefaultEventExecutorGroup(4);
        io.netty.util.concurrent.Future<Integer> submit = eventExecutors.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 100;
            }
        });

        submit.addListener(new FutureListener<Integer>() {
            @Override
            public void operationComplete(io.netty.util.concurrent.Future<Integer> future) throws Exception {
                future.get();
            }
        });


        //guava添加回调
        ListeningScheduledExecutorService listeningScheduledExecutorService = MoreExecutors.listeningDecorator(eventExecutors);
        ListenableFuture<Integer> listenableFuture = listeningScheduledExecutorService.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return 100;
            }
        });

        Futures.addCallback(listenableFuture, new FutureCallback<Integer>() {
            @Override
            public void onSuccess(@Nullable Integer result) {
                System.out.println("");
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println();
            }
        }, listeningScheduledExecutorService);


        //CompletableFuture  promise
        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            return 100;
        });

        integerCompletableFuture.whenComplete((result,e)->{
            System.out.println(result);
        });

        //thenApply 相当于回调函数


        // consume 进行消耗
        //thenAccept 接收上一步结果来进行操作
        //thenrun 直接运行 不需要接收
//        integerCompletableFuture.thenApply().thenAccept().thenRun()


    }
}
