package com.guava.basic;

import com.google.common.base.Optional;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkState;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/17
 */
public class OptionDemo {
    public static void main(String[] args) {
        String test = Optional.fromNullable((String)null).or(new String("test"));

        System.out.println(test);

        /**
         * 检验参数
         */
        int i=0;
        int j=0;
        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
        checkArgument(i < j, "Expected i < j, but %s > %s", i, j);

        checkState(i > j ,"i 小于 j");


    }
}
