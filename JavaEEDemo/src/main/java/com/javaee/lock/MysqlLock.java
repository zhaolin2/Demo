package com.javaee.lock;

import java.math.BigDecimal;

public class MysqlLock {

//    public void lock(){
//        while (true){
//            if(lock()){
//                return;
//            }
//
//            LockSupport.parkNanos(1000*1000*3);
//
//        }
//    }


    public void lock(){
    }

    public static void main(String[] args) {
        double a1=1.0;
        Double a2=1.00;
        BigDecimal num1 = new BigDecimal(a1);
        BigDecimal num2 = new BigDecimal(a2);
        System.out.println(num1.compareTo(num2));
    }
}
