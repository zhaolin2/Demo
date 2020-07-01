package com.javase.aop.cglibProxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("pre");
        Object intercept = methodProxy.invokeSuper(o, args); // 注意这里调用的是methodProxy.invokeSuper
        System.out.println("cglib代理");
        return intercept;
    }
}
