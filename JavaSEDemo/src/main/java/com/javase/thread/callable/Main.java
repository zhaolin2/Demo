package com.javase.thread.callable;

public class Main {
    public static void main(String[] args) {
        FutureClient futureClient=new FutureClient();
        Data request = futureClient.request("644");
        System.out.println("数据发送成功");
        System.out.println("主线程开始做其他任务");
        String result = request.getRequest();
        System.out.println("主线程获取到结果...."+result);
    }
}
