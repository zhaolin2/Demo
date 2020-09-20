package com.guava.basic;

import com.google.common.base.Function;
import com.google.common.base.Functions;

import java.util.HashMap;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/18
 */
public class FunctionsDemo {

    public static void main(String[] args) {
        /**
         *
         */
        HashMap<String, ComPareDomain> hashMap = new HashMap<>();
        Function<String, ComPareDomain> stringStringFunction = Functions.forMap(hashMap);
        ComPareDomain test = stringStringFunction.apply("test");

        // 前一个输出作为下一个function的输入 实现链式调用

    }
}
