package com.javase;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zl
 */
public class TempTest {
    public static void main(String[] args) {
        String hostUrl="";
        HashMap<String, String> params=new HashMap<>();

        StringBuilder stringBuilder = new StringBuilder(hostUrl).append("?");

        List<Integer> alist = new ArrayList<>();

        alist.add(1);

        alist.add(2);

        alist.add(3);

        List<Integer> blist = alist;

        blist.set(1, 1);

        System.out.println(alist.get(0));
        System.out.println(blist.get(1));

    }

}
