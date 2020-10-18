package com.netty;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/13
 */
public class FastThreadLocalDemo {

    private static FastThreadLocal<Integer> fastThreadLocal=new FastThreadLocal<>();
    public static void main(String[] args) {

        new FastThreadLocalThread(() -> {
            for (int i = 0; i < 100; i++) {
                fastThreadLocal.set(i);
                System.out.println(Thread.currentThread().getName() + "====" + fastThreadLocal.get());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "fastThreadLocal1").start();

    }
}
