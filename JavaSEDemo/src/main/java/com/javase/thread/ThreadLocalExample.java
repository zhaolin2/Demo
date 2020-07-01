package com.javase.thread;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalExample  {

    ThreadLocal<String> threadLocal=ThreadLocal.withInitial(()->{
        return "123";
    });

    public static void main(String[] args) throws InterruptedException {
        ThreadLocalExample threadLocalExample = new ThreadLocalExample();
        System.out.println(threadLocalExample.threadLocal.get());

        threadLocalExample.threadLocal.remove();
        threadLocalExample.threadLocal.set(null);

        System.out.println(threadLocalExample.threadLocal.get());
    }

}
