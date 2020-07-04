package com.javase.threadPool;

import lombok.ToString;

import java.time.LocalDate;
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
        System.out.println(Thread.currentThread().getName()+" StartTime= "+ LocalDate.now().toString());
        processCommand();
        System.out.println(Thread.currentThread().getName()+" EndTime= "+ LocalDate.now().toString());

    }

    private void processCommand() {
        try {
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
