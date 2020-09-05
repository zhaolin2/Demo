package com.javase.designPattern.chain;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:过滤链
 * @Author: zl
 * @date: 2020/8/19
 * 把每个处理的方法抽象成一个类
 * 把条件判断分散到不同的类 相对if else来说 耦合性降低
 */
public class FilterChain {

    List<Filter> filters = new ArrayList<>();

    //责任链初始化
    public FilterChain() {
        filters.add(new FilterEgg());
        filters.add(new FilterAoBing());
        filters.add(new FilterBaiCai());
        filters.add(new FilterJiTou());
    }

    //使用过滤链来进行处理
    public void processData(String data) {
        for (Filter filter : filters) {
            filter.doFilter(data);
        }
    }

}
