package com.javaee.rpc.proxy;

import java.lang.reflect.Proxy;

/**
 * @Description:代理测试
 * @Author: zl
 * @date: 2020/7/5
 */
public class ProxyTestDemo {

    public static void main(String[] args) throws Exception {
        BookApi delegate = new BookApiImpl();
        //Jdk代理
        System.out.println("Jdk动态代理--");
        BookApi jdkDynamicProxy = JdkProxy.createJdkDynamicProxy(delegate);
        jdkDynamicProxy.sell();

        //Cglib进行动态代理
        System.out.println("Cglib动态代理--");
        BookApi cglibDynamicProxy = CglibProxy.createCglibDynamicProxy(delegate);
        cglibDynamicProxy.sell();

        //JavassistProxy
        System.out.println("JavassistProxy动态代理--");
        BookApi javassistBytecodeDynamicProxy = JavassistProxy.createJavassistBytecodeDynamicProxy();
        javassistBytecodeDynamicProxy.sell();

//        Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),BookApi.class,new )
    }
}
