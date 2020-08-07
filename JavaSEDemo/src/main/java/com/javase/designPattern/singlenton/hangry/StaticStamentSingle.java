package com.javase.designPattern.singlenton.hangry;

/**
 * @Description:静态代码块实现单例
 * @Author: zl
 * @date: 2020/8/5
 */
public class StaticStamentSingle {

    private static StaticStamentSingle instance;

    static {
        instance=new StaticStamentSingle();
    }

    private StaticStamentSingle(){

    }
}
