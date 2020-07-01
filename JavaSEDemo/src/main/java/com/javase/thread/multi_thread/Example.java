package com.javase.thread.multi_thread;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Example {

    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);

        Thread fooThread = new Thread(() -> {
            try {
                fooBar.foo(() -> {
                    System.out.print("foo");
                });
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        fooThread.start();

        Thread barThread = new Thread(() -> {
            try {
                fooBar.bar(() -> {
                    System.out.print("bar");
                });
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });
        barThread.start();

        int string;


    }
}

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    //s1表示能够输出foo
    private Semaphore s1 = new Semaphore(1);
    //s2表示输出bar
    private Semaphore s2 = new Semaphore(0);

    public void foo(Runnable printFoo) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            //-1
            s1.acquire();
            printFoo.run();
            //+1
            s2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            s2.acquire();
            printBar.run();
            s1.release();
        }
    }
}




