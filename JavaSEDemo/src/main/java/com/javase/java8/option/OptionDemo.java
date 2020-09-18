package com.javase.java8.option;

import com.javase.designPattern.strategy.UserModel;

import java.util.Optional;

/**
 * 除了jdk中的
 * guava中其实也存在 并且感觉更加方便
 */
public class OptionDemo {
    public static void main(String[] args) {

        UserModel userModel = new UserModel();
        /**
         * 初始化
         * 第一种依然会抛出NPE
         * 第二种不会抛出
         */
        Optional.of(userModel);
        Optional.ofNullable(userModel);

        /**
         * orElse(T other)，为空不为空都会执行
         * orElseGet(Supplier<? extends T> other) 为空则会执行
         * orElseThrow(Supplier<? extends X> exceptionSupplier) 为空抛异常
         */
        Optional.ofNullable(userModel).orElseGet(() -> new UserModel());

        /**
         * map(Function<? super T, ? extends U> mapper)和
         * flatMap(Function<? super T, Optional<U>> mapper)
         * 这两个函数放在一组记忆，这两个函数做的是转换值的操作
         * 这两个区别就是 map里边直接放的是属性String这种的
         * flatMap这种的 放的就是Option<String> 这种的
         */

        /**
         * isPresent()和
         * ifPresent(Consumer<? super T> consumer)
         * 不为空的时候 做一些操作 参数类型不同而已
         */

        /**
         * filter 方法接受一个 Predicate 来对 Optional 中包含的值进行过滤，
         * 如果包含的值满足条件，那么还是返回这个 Optional；否则返回 Optional.empty。
         */

     
    }
}
