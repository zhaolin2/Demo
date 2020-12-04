package com.sinozo.guava.basic;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/17
 */
public class ObjectsDemo {

    public static void main(String[] args) {
        Objects.equal("test",null);

        Objects.hashCode("test");

        ObjectMapper objectMapper = new ObjectMapper();
        MoreObjects.toStringHelper(objectMapper).add("x",1).toString();

    }
}
