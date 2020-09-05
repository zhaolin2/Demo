package com.javase.designPattern.chain;

/**
 * @Description:请求处理类
 * @Author: zl
 * @date: 2020/8/19
 * 每次添加处理的时候 都需要对if来进行修改
 */
public class Handler {
    public void handlerRequest(Request request) {

        // 得到请求的数据
        String data = request.getData();

        if (data.contains("鸡蛋")) {
            filterEgg(data);
        }
        if (data.contains("敖丙工具")) {
            filterAoBing(data);
        }
        if (data.contains("白菜")) {
            filterBaiCai(data);
        }
        if (data.contains("鸡头")) {
            filterJiTou(data);
        }
        if (data.contains("鸡腿")) {
            filterJiTui(data);
        }
        // 我到这里就能拿到米豆了。
    }

    private void filterBaiCai(String data) {
        //doSomething
    }

    private void filterJiTou(String data) {
        //doSomething
    }

    private void filterJiTui(String data) {
        //doSomething
    }

    private void filterAoBing(String data) {
        //doSomething
    }

    private void filterEgg(String data) {
        //doSomething
    }
}
