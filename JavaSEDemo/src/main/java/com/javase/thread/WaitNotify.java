package com.javase.thread;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/13
 */
public class WaitNotify {
    public static void main(String[] args) throws InterruptedException {
        TaskQueue q = new TaskQueue();
        List<Thread> ts = new ArrayList<Thread>();
        for (int i=0; i<5; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    // 执行task:
                    while (true) {
                        try {
                            String s = q.getTask();
                            System.out.println("execute task: " + s);
                        } catch (InterruptedException e) {
                            return;
                        }
                    }
                }
            };
            t.start();
            ts.add(t);
        }
        Thread add = new Thread(() -> {
            for (int i=0; i<10; i++) {
                // 放入task:
                String s = "t-" + Math.random();
                System.out.println("add task: " + s);
                q.addTask(s);
                try { Thread.sleep(100); } catch(InterruptedException e) {}
            }
        });
        add.start();
        add.join();
        Thread.sleep(100);
        for (Thread t : ts) {
            t.interrupt();
        }
    }

}

class TaskQueue {
    Queue<String> queue = new LinkedList<>();

    /**
     * 添加之后 要唤醒在等待中的线程
     * @param s
     */
    public synchronized void addTask(String s) {
        this.queue.add(s);
        this.notifyAll();
    }

    /**
     * 循环判断 因为在wait之后 只会有一次获取到锁 剩下的依然在等待
     */
    public synchronized String getTask() throws InterruptedException {
        while (queue.isEmpty()) {
            this.wait();
        }
        return queue.remove();
    }
}
