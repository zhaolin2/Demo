package com.javase.java8.lambda;

import cn.hutool.core.lang.tree.parser.NodeParser;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author zl
 * predict (T) -> boolean
 * consumer  (T) -> void
 * supply () -> T
 * apply (T) -> R
 * compatator  (T,T) -> int
 */
public class FuncationInterfaceDemo {



    public FuncationInterfaceDemo(){

    }

    public FuncationInterfaceDemo(String name){
        this.name=name;
    }

    public static void main(String[] args) {
        FuncationInterfaceDemo funcationInterfaceDemo = new FuncationInterfaceDemo();

//        funcationInterfaceDemo.prediceTest();

//        funcationInterfaceDemo.consumer();

        funcationInterfaceDemo.supply();
    }


    /**
     * 除了lambda  也还有 与或非 三种表示  来进行复合操作
     * (T) -> boolean
     */
    private void prediceTest(){
        Predicate<Integer> isEven=(in) -> in % 2 == 0;
        isEven.test(15);

        System.out.println(isEven.negate().test(16));

    }

    /**
     * 接收对象 执行操作  没有返回值
     * (T) -> void
     */
    private void consumer(){
        Consumer<String> printAppleColor = System.out::println;
        printAppleColor.accept(new String("red"));
        // red

        //在后边拼接输出
//        printAppleColor.andThen((a) -> System.out.println(a.getWeight())).accept(new Apple("red", 17)); // red 17.0

    }

    /**
     * 无参数  返回泛型
     * () -> T
     */
    private void supply(){
        Supplier<FuncationInterfaceDemo> personSupplier = FuncationInterfaceDemo::new;
        // new FuncationInterfaceDemo
        FuncationInterfaceDemo funcationInterfaceDemo = personSupplier.get();
        System.out.println(funcationInterfaceDemo.hashCode());
    }

    /**
     * 接收一个泛型  返回一个泛型
     * (T) -> R
     */
    private void apply(){
        Function<FuncationInterfaceDemo, String> getAppleWeight = (a) -> {
            return a.getName();
        };

        getAppleWeight.apply(new FuncationInterfaceDemo("pass")); // 17.0
    }

    /**
     * (T,T) -> int
     */
    private void comparator(){

        List<Double> list = new ArrayList<>();
        list.add(12.3);
        list.add(100.2);
        list.add(3.14);
        list.add(27.7);
        list.add(-9.8);

        Collections.sort(list, new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                return o1.compareTo(o2);
            }
        });



        Collections.sort(list, (o1, o2) -> o1.compareTo(o2));
        list.sort((o1, o2) -> o1.compareTo(o2));

        Comparator<Double> comparator = Double::compareTo;
        list.sort(comparator.reversed());


    }


    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
