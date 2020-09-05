package com.javase.designPattern.chain;

/**
 * 过滤的抽象类
 */
public interface Filter {
    // 过滤
    void doFilter(String data);

}

class FilterEgg implements Filter {

    @Override
    public void doFilter(String data) {
        //doSomething
    }
}

class FilterAoBing implements Filter {

    @Override
    public void doFilter(String data) {
        //doSomething
    }
}

class FilterBaiCai implements Filter {

    @Override
    public void doFilter(String data) {
        //doSomething
    }
}

class FilterJiTou implements Filter {

    @Override
    public void doFilter(String data) {
        //doSomething
    }
}