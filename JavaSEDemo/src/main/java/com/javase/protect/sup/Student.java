package com.javase.protect.sup;

import com.javase.protect.sub.Pearson;

/**
 * @author zl
 */
public class Student extends Pearson {
    int getB(){
        return getA();
    }

    public static void main(String[] args) {
        Manage manage = new Manage();
        System.out.println(manage.getB());
//        System.out.println(manage.getA());
    }
}
