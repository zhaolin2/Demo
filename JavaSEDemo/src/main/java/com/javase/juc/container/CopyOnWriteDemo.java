package com.javase.juc.container;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/16
 */
public class CopyOnWriteDemo {

    public static void main(String[] args) {
        ArrayList<String> resources = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        CopyOnWriteArrayList<Integer> copyOnWriteArrayList = new CopyOnWriteArrayList<>();



        resources.stream().parallel().forEach(str ->{
            long count = str.codePoints().count();

            copyOnWriteArrayList.add((int) count);
        });

        List<Result> list = new CopyOnWriteArrayList<>();


        List<Callable<Void>> callables = resources.stream()
                .map(s -> (Callable<Void>) () -> {
//                    User user = computeTarget(resources, users);
//                    Result result = distribute(resources, user);
//                    list.add(result);
                    return null;
                }).collect(Collectors.toList());

        invokeAll(callables, 20, TimeUnit.SECONDS);
    }

    // 使用线程池来进行处理 来代替stream并行默认的forkjoin线程池
    private static void invokeAll(List<Callable<Void>> callables, int i, TimeUnit seconds) {

    }

    private class Result{

    }

    private class User {

    }
}
