package com.javase.java8.stream;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * {@link Stream#reduce(java.lang.Object, java.util.function.BiFunction, java.util.function.BinaryOperator)}
 * U identity 初始值 可以是一般对象或者是新建列表
 * BiFunction<U, ? super T, U> accumulator    传入一个初始类型值U，stream的类型T，最后返回一个初始类型U的实例
 * BinaryOperator<U> combiner 多线程下的容器合并
 *
 */
public class ReduceDemo {
    public static void main(String[] args) {
        ArrayList<String> result = Stream.of("aa", "ab", "c", "ad").reduce(new ArrayList<>(),
                (u, s) -> {
                    u.add(s);
                    return u;
                }, (strings, strings2) -> strings);
        System.out.println(result); //[aa, ab, c, ad]
    }

}
