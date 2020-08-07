package com.javase.designPattern.singlenton.lazy;

/**
 * @Description:synchronized来实现懒汉式的单例
 * @Author: zl
 * @date: 2020/8/5
 * 在实现的时候才会进行初始化
 * 有个问题 在初始化之后依然还有锁 访问会慢
 */
public class SynchronizedSingleton {

    private static SynchronizedSingleton instance;

    private SynchronizedSingleton(){

    }

    synchronized public static SynchronizedSingleton getInstance(){
        if (null == instance ){
            instance=new SynchronizedSingleton();
        }

        return instance;
    }
}
