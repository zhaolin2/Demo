package com.javase.designPattern.strategy;

/**
 * @Description:主要是3y的例子
 * @Author: zl
 * @date: 2020/8/18
 * https://mp.weixin.qq.com/s/CeBqNe8rj0uNPuj5rE5QhA
 * 虽然说的是责任链模式 但是给我的感觉更像是策略模式为主
 * 然后责任链作为每个策略的实现
 */
public class StrategyClient {

    public static void main(String[] args) {

        //可以使用spring来完成注入
        ProcessController processController = new ProcessController();
        String userName = "张三";


        // 构建上下文
        ProcessContext processContext = new ProcessContext();

        UserModel userModel = new UserModel();
        userModel.setAge("22");
        userModel.setName(userName);
        processContext.setModel(userModel);

        processContext.setCode("sendMessage");

        processController.process(processContext);

        if ("3y".equals(userModel.getName())) {
            return;
        }
        System.out.println("给" + userModel.getName() + "发消息");
    }
}
