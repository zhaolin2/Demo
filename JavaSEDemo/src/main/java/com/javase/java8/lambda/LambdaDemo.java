package com.javase.java8.lambda;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zl
 */
public class LambdaDemo {

    private String name;

    public static void main(String[] args) {
        LambdaDemo lambdaDemo = new LambdaDemo();

    }

    private void baseUse(){
//        List<String> list = new ArrayList<>();
//        Runnable r = () -> list.add("hello");

        //Lambda表达式可以访问局部final变量，成员变量和静态变量。
        String hello = "hello lambda";
        Runnable r = () -> System.out.println(this.name);
        hello="123";
    }
}
