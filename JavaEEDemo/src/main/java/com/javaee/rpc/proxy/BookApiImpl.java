package com.javaee.rpc.proxy;

/**
 * @Description: 代理实现类
 * @Author: zl
 * @date: 2020/7/5
 */
public class BookApiImpl implements BookApi {
    @Override
    public void sell() {
        System.out.println("com.javaee.rpc.proxy.BookApiImpl.sell");
    }
}
