package com.javase.jdkClass.string;

import java.util.StringJoiner;

/**
 * @Description:StringBuilder的demo
 * @Author: zl
 * @date: 2020/8/9
 * 可以构造一个string连接  包括分隔符  前缀 后缀
 */
public class StringJoinerDemo {
    public static void main(String[] args) {
        StringJoiner stringJoiner = new StringJoiner(",");

        stringJoiner.add("123");
        stringJoiner.add("45600");

        stringJoiner.add("test");
        stringJoiner.add("jes");

        System.out.println(stringJoiner.length());
        System.out.println(stringJoiner.toString());
    }

    public void mergeDemo(){
         String PREFIX = "[";
         String SUFFIX = "]";

        StringJoiner rgbJoiner = new StringJoiner(
                ",", PREFIX, SUFFIX);
        StringJoiner cmybJoiner = new StringJoiner(
                "-", PREFIX, SUFFIX);

        rgbJoiner.add("Red")
                .add("Green")
                .add("Blue");
        cmybJoiner.add("Cyan")
                .add("Magenta")
                .add("Yellow")
                .add("Black");

        rgbJoiner.merge(cmybJoiner);

        assert "[Red,Green,Blue,Cyan-Magenta-Yellow-Black]".equals(rgbJoiner.toString());
    }
}
