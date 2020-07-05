package com.javase.juc;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author zl
 */
public class LongAdderDemo {

    public static void main(String[] args) {
        LongAdder longAdder = new LongAdder();
        longAdder.add(500L);

        longAdder.increment();
        longAdder.decrement();

        System.out.println(longAdder.sum());
        new Long(new Integer(1).byteValue());
    }
}
