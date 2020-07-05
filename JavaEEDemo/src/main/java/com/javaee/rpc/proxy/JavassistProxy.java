package com.javaee.rpc.proxy;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;

/**
 * @Description:javassist动态代理
 * @Author: zl
 * @date: 2020/7/5
 */
public class JavassistProxy {
    public static BookApi createJavassistBytecodeDynamicProxy() throws Exception {
        ClassPool mPool = new ClassPool(true);
        CtClass mCtc = mPool.makeClass(BookApi.class.getName() + "JavaassistProxy");
        mCtc.addInterface(mPool.get(BookApi.class.getName()));
        mCtc.addConstructor(CtNewConstructor.defaultConstructor(mCtc));
        mCtc.addMethod(CtNewMethod.make(
                "public void sell(){ System.out.print(\"Javassist\") ; }", mCtc));
        Class<?> pc = mCtc.toClass();
        BookApi bytecodeProxy = (BookApi) pc.newInstance();
        return bytecodeProxy;
    }
}
