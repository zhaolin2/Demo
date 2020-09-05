package com.javase.designPattern.chain;

import com.javase.thread.main;

/**
 * @Description:经过处理之后的代码
 * @Author: zl
 * @date: 2020/8/19
 */
public class ChainClient {
    public static void main(String[] args) {
        //初始化数据
        Request request=new Request();


        // 得到请求的数据
        String data = request.getData();
        FilterChain filterChain = new FilterChain();
        // 处理数据
        filterChain.processData(data);
    }
}
