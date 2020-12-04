package com.sinozo.guava.continer;

import com.google.common.collect.ConcurrentHashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multisets;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/19
 */
public class MuliDemo {
    public static void main(String[] args) {
        ConcurrentHashMultiset<String> stringConcurrentHashMultiset = ConcurrentHashMultiset.create();

        stringConcurrentHashMultiset.add("1");


    }
}
