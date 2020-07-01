package com.javase.protect.sup;

import com.javase.protect.sub.Pearson;
import com.sun.xml.internal.ws.api.ha.StickyFeature;

/**
 * @author zl
 */
public class Manage extends Pearson {

    int getB(){
        return getA();
    }

    public static void main(String[] args) {
        Student student = new Student();
        System.out.println(student.getB());
//        System.out.println(student.getA());
    }
}
