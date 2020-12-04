package com.javase.java8.stream;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link Collectors} 第一个是使用jdk定义好的
 * {@link Stream#collect(java.util.function.Supplier, java.util.function.BiConsumer, java.util.function.BiConsumer)}
 * supplier : 提供一个结果容器
 * accumulator： 将结果放在 supplier 产生的结果容器中
 * combiner ： 合并两个结果容器(为多线程作准备)
 */
public class CollectDemo {

    @AllArgsConstructor
    @Data
    private static class Person{
        private String id;
        private String name;
    }

    public static void main(String[] args) {
        // 声明一个List集合
        List<Person> list = new ArrayList();
        list.add(new Person("1001", "小A"));
        list.add(new Person("1002", "小B"));
        list.add(new Person("1003", "小C"));
        list.add(new Person("1003", "小D"));
//        list.add(new Person("1004", null));
//        list.add(new Person(null, "小D"));
        // 将list转换map
//        Map<String, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName));
        // 后面的值代替之前的值  merge
//        Map<String, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName,(value1 , value2)-> value2 ));
        // 重复时将前面的value 和后面的value拼接起来
//        Map<String, String> map = list.stream().collect(Collectors.toMap(Person::getId, Person::getName,(value1 , value2)-> value1+","+value2 ));
        // 重复时将重复key的数据组成集合
//        Map<String, List<String>> map = list.stream().collect(Collectors.toMap(Person::getId, p -> {
//            List<String> getNameList = new ArrayList<>();
//            getNameList.add(p.getName());
//            return getNameList;
//        }, (List<String> value1, List<String> value2) -> {
//            value1.addAll(value2);
//            return value1;
//        }));

//        Map<String, String> map = list.stream().collect(LinkedHashMap::new,(k, v) ->k.put(v.getId(),v.getName()),LinkedHashMap::putAll);
//        System.out.println(map);

       list.stream().collect(Collectors.toMap(Person::getId, Person::getName));

        list.stream().collect(Collectors.toMap(Person::getId, Person::getName,(oldV, newV) -> oldV + newV + 10, HashMap::new));

       list.stream().collect(LinkedHashMap::new,(map,ele) ->{
           map.put(ele.getId(),ele.getName());
       },LinkedHashMap::putAll);
    }
}
