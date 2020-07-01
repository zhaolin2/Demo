package com.javase.aop.cglibProxy;

import com.javase.aop.HelloImpl;
import net.sf.cglib.proxy.Enhancer;

public class CglibMain {

    public static void main(String[] args) throws Exception {
        Enhancer enhancer = new Enhancer();

        enhancer.setSuperclass(HelloImpl.class); // 注意此处的类型必须是实体类
        enhancer.setCallback(new MyMethodInterceptor());

        HelloImpl helloService = (HelloImpl) enhancer.create();
        helloService.sayHello();

    }
}
