package com.javase.jvm;

import org.openjdk.jol.info.ClassLayout;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author zl
 * 查看对象的内存布局
 */
public class ObjectStore {
    public static void main(String[] args){
        Object obj = new Object();
        System.out.println(ClassLayout.parseInstance(obj).toPrintable());

        List list=new ArrayList();
        list.add("123");
        list.add(123);

//        new Collection<>();
        System.out.println(list.get(0).getClass().getTypeName());
        System.out.println(list.get(1).getClass().getTypeName());
        list.get(1).getClass().getTypeName();

    }
}
