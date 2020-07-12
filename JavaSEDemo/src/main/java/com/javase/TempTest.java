package com.javase;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 简单测试类
 */
public class TempTest {

    static String pass;

    public static void main(String[] args) {
        TempTest tempTest = new TempTest();
        String pass = TempTest.pass;
        Class<? extends TempTest> aClass = tempTest.getClass();

    }

    public void test(){
        pass="123";
    }

}
