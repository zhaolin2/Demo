package com.javase.juc.container;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/7/15
 */
public class JUCContainerDemo {
    public static void main(String[] args) {
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        objects.add("123");
        Integer $a=123;
        Integer _a=123;
        Integer a=123;

    }
}
