package com.collection;

import org.junit.Test;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/11/22
 */
public class CollectionTest {

    @Test
    public void  enumTest(){
        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        stringStringHashtable.put("123","123");
        stringStringHashtable.put("456","123");
        stringStringHashtable.put("789","123");

//        Enumeration<String> elements = stringStringHashtable.elements();
//        while (elements.hasMoreElements()){
//            stringStringHashtable.put("423423","6546");
//            System.out.println(elements.nextElement());
//        }

//        Iterator<Map.Entry<String, String>> iterator = stringStringHashtable.entrySet().iterator();
//        while (iterator.hasNext()){
//            stringStringHashtable.put("5334","3534");
//            Map.Entry<String, String> next = iterator.next();
//            System.out.println(next);
//        }

        CopyOnWriteArrayList<String> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        Iterator<String> copyOnWriteArrayListIterator = copyOnWriteArrayList.iterator();

        while (copyOnWriteArrayListIterator.hasNext()){
            copyOnWriteArrayList.add("123");
            System.out.println(copyOnWriteArrayListIterator.next());
        }
    }
}
