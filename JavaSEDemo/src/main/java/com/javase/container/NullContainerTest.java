package com.javase.container;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Description:null值测试
 * @Author: zl
 * @date: 2020/7/12
 */
public class NullContainerTest {
    public static void main(String[] args) {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put(null,null);

        //NullPointerException
//        TreeMap<Object, Object> treeMap = new TreeMap<>();
//        treeMap.put(null,null);

        //java.lang.NullPointerException
//        Hashtable<Object, Object> hashtable = new Hashtable<>();
//        hashtable.put(null,null);

        //NullPointerException
//        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
//        concurrentHashMap.put(null,null);


    }
}