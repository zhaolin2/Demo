package com.javase.designPattern.strategy.impl;


import com.javase.designPattern.strategy.BusinessProcess;
import com.javase.designPattern.strategy.ProcessContext;
import com.javase.designPattern.strategy.UserModel;

/**
 * 白名单处理器
 * @author 3y
 */
public class WhiteListProcess implements BusinessProcess {

    @Override
    public void process(ProcessContext context) {
        UserModel user = (UserModel) context.getModel();
        if ("3y".equals(user.getName())) {
            context.setNeedBreak(true);
        }
    }
}
