package com.javase.aop.jdkProxy;


import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class JdkMain {
     public static  void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Object proxyInstance = Proxy.newProxyInstance(JdkMain.class.getClassLoader(),
//                new Class[]{Hello.class}, new MyInvocationHandler(new HelloImpl()));
//        Hello proxyHello=(Hello)proxyInstance;
//        proxyHello.sayHello();


        // 三个步骤：
        // 1、生成代理接口的Class（） class com.sun.proxy.$Proxy0
        // 2、拿到构造器：public com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler)
        // 3、new一个InvocationHandler实例~~~
//        Class<?> proxyClass = Proxy.getProxyClass(JdkMain.class.getClassLoader(), Hello.class);
//        Constructor<?> cons = proxyClass.getConstructor(InvocationHandler.class);
//        InvocationHandler ih = new MyInvocationHandler(new HelloImpl());

         ArrayList<String> strings = new ArrayList<>(200);
         strings.add("1");
         System.out.println(strings.size());
     }
}
