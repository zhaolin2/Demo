package com.javase.container.collection.list;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description:常用集合类Arraylist的demo
 * @Author: zl
 * @date: 2020/7/15
 */
public class ArrayListDemo {
    public static void main(String[] args) {
//        List<String> arrayList = new ArrayList<>();
//        arrayList.add(null);
//        arrayList.add("test");
//        arrayList.forEach(System.out::println);

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add(null);
        linkedList.add("test");
        linkedList.forEach(System.out::print);

        ArrayDeque<Object> arrayDeque = new ArrayDeque<>();

//        arrayDeque.push(null);
//        System.out.println(arrayDeque.pop());
        arrayDeque.push("123");

        System.out.println(arrayDeque.size());

    }
}
