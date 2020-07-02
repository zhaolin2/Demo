package com.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author zl
 *
 * BiMap是一种特殊的，双向映射的Map，可以确保不会出现重复的值并且我们总是可以安全地通过key获取到value。BiMap的基本实现为HashBiMap。
 */
public class BiMapDemo {

    /**
     * 往BiMap里添加重复的值将会报错：
     * 如果非要添加重复的值的话，可以用forcePut方法：
     * @param args
     */
    public static void main(String[] args) {

        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("k1", "v1");
        biMap.put("k2", "v2");
        biMap.put("k3", "v3");
        System.out.println(biMap); // {k1=v1, k2=v2, k3=v3}

        BiMap<String, String> inverse = biMap.inverse();
        System.out.println(inverse); // {v1=k1, v2=k2, v3=k3}

//        BiMap<String, String> biMap = HashBiMap.create();
        biMap.put("k1", "v1");
        biMap.put("k2", "v2");
        biMap.forcePut("k3", "v1");
        System.out.println(biMap); // {k2=v2, k3=v1}
    }
}
