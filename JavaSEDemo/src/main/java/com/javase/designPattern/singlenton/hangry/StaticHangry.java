package com.javase.designPattern.singlenton.hangry;

import sun.security.jca.GetInstance;

/**
 * @Description:使用静态对象来实现
 * @Author: zl
 * @date: 2020/8/5
 */
public class StaticHangry {

    private static StaticHangry instance=new StaticHangry();

    private StaticHangry(){

    }

    public static StaticHangry getInstance(){
        return instance;
    }
}
