package com.javase.designPattern.strategy.impl;


import com.javase.designPattern.strategy.BusinessProcess;
import com.javase.designPattern.strategy.ProcessContext;
import com.javase.designPattern.strategy.UserModel;

/**
 * 发消息处理器
 * @author 三歪
 */
public class SendMessageProcess implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        UserModel user = (UserModel) context.getModel();
        System.out.println("给"+user.getName()+"发消息");
    }
}
