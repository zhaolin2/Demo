package com.javase.type;

import com.sun.org.apache.xml.internal.security.Init;

/**
 * @Description:方法调用 值传递
 * @Author: zl
 * @date: 2020/7/18
 * 对于方法传递来说 方法调用都是值传递
 * 只不过对于引用来说  他们本来就是指向堆中对象的引用的值
 */
public class MethodInvoke {
    private static int intStatic = 222;
    private static String stringStatic = "old string";
    private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");

    public static void main(String[] args) {
//        method(intStatic);
        method(stringStatic);
//        method(stringBuilderStatic, stringBuilderStatic);

        //并没有改变
//        System.out.println(intStatic);
//        method();
        //改变了
//        System.out.println(intStatic);

        //复制了字符串
//        System.out.println(stringStatic);

        //复制了引用
//        System.out.println(stringBuilderStatic);
//
//        StringBuilder stringBuilder = new StringBuilder("inner builder");
//        method(stringBuilder,stringBuilder);
//        System.out.println(stringBuilder.toString());
    }

    //拷贝了静态变量的值 赋值给形参
    public static void method(int intStatic) {
        intStatic = 777;
    }

    //修改的是静态变量的值
    public static void method() {
        intStatic = 888;
    }

    public static void method(String stringStatic) {
        stringStatic = "new string";
    }

    //这两个引用都是被静态变量的引用赋值给栈帧中的局部变量表
    public static void method(StringBuilder stringBuilderStaticl,
                              StringBuilder stringBuilderStatic2) {
        stringBuilderStaticl.append("-method first");
        stringBuilderStatic2.append("-method second");
        stringBuilderStaticl = new StringBuilder("new StringBuilder");
        stringBuilderStaticl.append("new build append");
    }

}
