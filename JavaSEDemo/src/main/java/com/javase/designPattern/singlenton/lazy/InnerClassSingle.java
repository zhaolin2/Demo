package com.javase.designPattern.singlenton.lazy;

/**
 * @Description:内部类来实现单例
 * @Author: zl
 * @date: 2020/8/5
 * 因为类在加载的过程中，是单个线程来进行加载的 所以不需要同步
 * 并且由于是内部类 只有在使用的时候才会去加载
 */
public class InnerClassSingle {

    private InnerClassSingle(){

    }

    static public InnerClassSingle getInstance(){
        return InnerClassHolder.instance;
    }

    private static class InnerClassHolder{
        private static final InnerClassSingle instance=new InnerClassSingle();
    }
    
}
