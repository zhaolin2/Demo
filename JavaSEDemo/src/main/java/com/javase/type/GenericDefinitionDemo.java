package com.javase.type;

/**
 * @Description: 泛型demo
 * @Author: zl
 * @date: 2020/7/18
 */
public class GenericDefinitionDemo<T> {

    /**
     *
     * @param string
     * @param alibaba
     * @param <String>  定义了一个泛型叫做String  并不是java.lang.string
     * @param <T> 泛型T
     * @param <Alibaba> 泛型Alibaba
     * @return
     */
    static <String, T, Alibaba> String get(String string, Alibaba alibaba) {
        return string;
    }

    public static void main(String[] args) {
        Integer first = 222;
        Long second = 333L;
        //
        Integer result = get(first, second);

        System.out.println(result);
    }

}
