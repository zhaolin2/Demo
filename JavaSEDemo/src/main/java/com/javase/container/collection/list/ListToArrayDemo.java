package com.javase.container.collection.list;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: list转化为Array
 * @Author: zl
 * @date: 2020/7/20
 * 在转化为数组的时候 数组的类型要跟原始类型一致
 * 容量要相同 不然转化效率比较慢
 */
public class ListToArrayDemo {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>( 3 );
        list.add ("one");
        list.add("two");
        list.add ("threee" );
        //泛型丢失
        Object[] arrayl = list.toArray();
        System.out.println((String) arrayl[0].toString());

        //array的数组长度小于元素个数
        //[null, null]
        String[] array2 = new String[ 2 ] ;
        list.toArray(array2);
        System . out.println(Arrays.asList(array2)) ;

        //array长度等于元素个数
        //[one, two, threee]
        String[] array3 = new String[ 3 ];
        list.toArray(array3 );
        System.out . println(Arrays.asList(array3));


        Object o = Array.newInstance(String.class, 10);
        String[] arr= (String[]) o;

        Integer[] a=new Integer[5];
        Object[] objects=new Object[5];
        objects=a;

    }


    private static  <T> T[] toArray(List<T> list,Class clazz){
        if (list.size()!=0 ){
            T t = list.get(0);

        }

        return (T[]) list.toArray();



    }

}
