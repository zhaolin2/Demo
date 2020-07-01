package com.javase.thread.threadPool;

import com.javase.thread.callable.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @author zl
 */
@ToString
public class MyRunnable implements Runnable {
    private String command;

    public MyRunnable(String s){
        this.command=s;

    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" StartTime= "+ new Date());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" EndTime= "+ new Date());

    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
