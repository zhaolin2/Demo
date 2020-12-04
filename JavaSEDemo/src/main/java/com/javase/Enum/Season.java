package com.javase.Enum;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/2
 */
public enum  Season {
    /**
     *
     */
    SPRING,SUMMER,AUTUMN,WINTER;

    public static void main(String[] args) throws NoSuchFieldException {
        Season season=Season.AUTUMN;
//        switch (season){
//            case AUTUMN:
//                System.out.println("");
//                break;
//            case SPRING:
//                System.out.println("");
//                break;
//            default:
//                System.out.println("");
//                break;
//        }

//        Field summer = Season.class.getDeclaredField("SUMMER");
//        System.out.println(summer);

        Constructor<?>[] constructors = Season.class.getConstructors();
        System.out.println(constructors.length);
    }
}
