package com.javase.serialization.json;

import com.alibaba.fastjson.JSON;
import com.javase.serialization.Person;

/**
 * @Description:fastJson序列化的Demo
 * @Author: zl
 * @date: 2020/8/3
 * 主要方法都写在JSON里边
 */
public class FastJsonDemo {
    public static void main(String[] args) {

        Person buildPearson = new Person().setAge(12).setName("213");
        String personJsonString = JSON.toJSONString(buildPearson);

        System.out.println(personJsonString);
    }
}
