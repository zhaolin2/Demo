package com.javase.java8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author zl
 * 流一般有三种操作
 *  数据源
 *  中间操作链
 *  中断操作
 *
 *  具体的函数看 note/Java/Java8.md
 *
 *  stream不同于io 主要是进行的计算
 *
 *  集合讲的是数据，流讲的是计算  不保存数据，关于的是算法和计算，像是高版本的iterator
 *  Stream 就如同一个迭代器（Iterator），单向，不可往复，数据只能遍历一次，遍历过一次后即用尽了，就好比流水从面前流过，一去不复返
 *
 *  unordered 不在乎顺序 放宽顺序可能会使得执行效率更高
 *  peek 主要功能是用来debug 来对stream的中间过程进行输出
 */
public class StreamDemo {
    public static void main(String[] args) {

//        List<String> list = Arrays.asList("Java", "JavaScript", "python", "PHP", "C#", "Golang", "Swift", "C++", "Ruby");

        /**
         * 5126374
         * 3614275
         */
        Stream.of(5,1,2,6,3,7,4).unordered().forEach(System.out::print);
        System.out.println();
        Stream.of(5,1,2,6,3,7,4).unordered().parallel().forEach(System.out::print);

        Stream.of(5,1,2,6,3,7,4).peek(System.out::println).forEach(System.out::println);

        Stream.of(5,1,2,6,3,7,4).mapToLong(e ->{
            return e+10;
        }).sum();

    }
}
