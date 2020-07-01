package com.javase;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author zl
 */
public class LRULinkedHashMap<I extends Number, I1 extends Number> extends LinkedHashMap {

    private int capacity;

    LRULinkedHashMap(int initCapacity){
        super(16,0.75f,true);
        this.capacity=initCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        System.out.println("remove entry: "+eldest.getKey()+"="+eldest.getValue());
        return size()>capacity;
    }
}
