package com.javaee.rpc.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Description:jdk动态代理接口
 * @Author: zl
 * @date: 2020/7/5
 */
public class JdkProxy {

    /**
     * 反射调用
     * Method method = serviceClass.getMethod(methodName, new Class[]{});
     * method.invoke(delegate, new Object[]{});
     * @param delegate
     * @return
     */

    public static BookApi createJdkDynamicProxy(final BookApi delegate) {
        BookApi jdkProxy = (BookApi) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),
                new Class[]{BookApi.class}, new JdkHandler(delegate));
        return jdkProxy;
    }

    private static class JdkHandler implements InvocationHandler {

        final Object delegate;

        JdkHandler(Object delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object invoke(Object object, Method method, Object[] objects)
                throws Throwable {
            // 添加代理逻辑 <1>
            if ("sell".equals(method.getName())) {
                System.out.println("com.javaee.rpc.proxy.JdkProxy.JdkHandler.invoke");
            }
//            return null;
            return method.invoke(delegate, objects);
        }

    }
}

