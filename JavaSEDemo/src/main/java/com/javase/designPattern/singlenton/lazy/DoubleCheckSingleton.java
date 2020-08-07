package com.javase.designPattern.singlenton.lazy;

import java.io.Serializable;
/**
 * @Description:双重校验锁来实现单例
 * @Author: zl
 * @date: 2020/8/5
 * 会比直接加锁快一点 为空才会去竞争
 * 不为空直接往下走
 */
public class DoubleCheckSingleton implements Serializable {

    private static volatile DoubleCheckSingleton singleton;

    private DoubleCheckSingleton() {
    }

    public static DoubleCheckSingleton getSingleton() {

        if (singleton == null) {
            synchronized (DoubleCheckSingleton.class) {
                if (singleton == null) {
                    singleton = new DoubleCheckSingleton();
                }
            }
        }

        return singleton;
    }

    private Object readResolve() {
        return singleton;
    }


}
