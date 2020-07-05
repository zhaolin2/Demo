package com.javaee.rpc.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Description:cglib动态代理
 * @Author: zl
 * @date: 2020/7/5
 */
public class CglibProxy {

    /**
     * 反射调用
     * FastClass serviceFastClass = FastClass.create(serviceClass);
     * FastMethod serviceFastMethod = serviceFastClass.getMethod(methodName, new Class[]{});
     * serviceFastMethod.invoke(delegate, new Object[]{});
     * @param delegate
     * @return
     * @throws Exception
     */
    public static BookApi createCglibDynamicProxy(final BookApi delegate) throws Exception {
        Enhancer enhancer = new Enhancer();
        enhancer.setCallback(new CglibInterceptor(delegate));
        enhancer.setInterfaces(new Class[]{BookApi.class});
        BookApi cglibProxy = (BookApi) enhancer.create();
        return cglibProxy;
    }

    private static class CglibInterceptor implements MethodInterceptor {

        final Object delegate;

        CglibInterceptor(Object delegate) {
            this.delegate = delegate;
        }

        @Override
        public Object intercept(Object object, Method method, Object[] objects,
                                MethodProxy methodProxy) throws Throwable {
            // 添加代理逻辑
            if("sell".equals(method.getName())) {
                System.out.println("com.javaee.rpc.proxy.CglibProxy.CglibInterceptor.intercept");
            }
//            return null;
            return methodProxy.invoke(delegate, objects);

            //1 白蝌蚪 0.625
            // 1  0.5
            //1   0.416
        }
    }
}
