package com.javase.thread;

/**
 * @author zl
 */
public class ThreadGroupDemo {

    public static void main(String[] args) {
        ThreadGroup group = new ThreadGroup("groupDemo");

        System.out.println(Thread.currentThread().getThreadGroup().getName());
    }
}
