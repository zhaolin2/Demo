package com.javase.designPattern.chain;

/**
 * @Description:请求抽象
 * @Author: zl
 * @date: 2020/8/19
 */
public class Request {
    // 请求的数据
    private String data;

    public String getData() {
        return data;
    }
    public void setData(String data) {
        this.data = data;
    }
}
