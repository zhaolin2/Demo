package com.javase.thread.annotation;

import net.sf.cglib.proxy.Enhancer;

public class Main {
    public static void main(String[] args) {
//        TimeUtils tu = new TimeUtils();
//        tu.getTime();
//        testMethod();
        Main main = new Main();
        CglibTimer cglibTimer = new CglibTimer();
        Main instance = (Main)cglibTimer.getInstance(main);
//        System.out.println(instance.toString());
        instance.mainMethod();
    }


    public void mainMethod(){
        //这个才是真正的main方法
        test();
        System.out.println("mainMethod");
    }

    @Timer
    public void test(){
        System.out.println("this is the test");
    }
}
