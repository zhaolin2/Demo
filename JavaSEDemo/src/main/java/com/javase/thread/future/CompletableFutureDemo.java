package com.javase.thread.future;

import java.util.concurrent.CompletableFuture;

/**
 * 可以使用future来让不需要前后关系的来进行并行操作
 *
 */
public class CompletableFutureDemo {
    public static void main(String[] args) {

    }

    /**
     * 在从数据库拼接数据的时候，可以使用这种来并行查询来提高速度
     */
    public void seriaTopParallel(){
        // 串行方式：
//        OneDTO one = oneService.get();
//        TwoDTO two = twoService.get();
//        ThreeDTO three = threeService.get();
//        nextHandle(new Result(one, two, three));

        Result result = new Result();

        CompletableFuture<Void> info1Future = CompletableFuture.runAsync(() -> setResInfo1(result));
        CompletableFuture<Void> info2Future = CompletableFuture.runAsync(() -> setResInfo2(result));

        CompletableFuture.allOf(info1Future,info2Future).thenRun(() -> nextHandle(result));



    }

    private void setResInfo1(Result res){

    }

    private void setResInfo2(Result res){

    }

    private void nextHandle(Result result){

    }

    private class Result{

    }
}
