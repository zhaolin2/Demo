package com.sinozo.lang3;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.google.common.collect.Streams;
import org.apache.commons.collections4.CollectionUtils;


import java.util.*;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/11/21
 */
public class CollectionDemo {

    public static void main(String[] args) {
        List<String> objects = Lists.newArrayList();

        if (CollectionUtils.isNotEmpty(objects)){

        }

        //将两个排序的集合相加为同一个集合 保留自然顺序
        CollectionUtils.collate(objects,objects);

        //返回异或的结果集 union(a,b)    subtract(a,b)
        CollectionUtils.disjunction(objects,objects);

        //根据条件进行过滤
        CollectionUtils.select(objects, str -> "1".equals(str));

        //把特定类型转变为另外的类型
        CollectionUtils.collect(objects, Integer::parseInt);

        //从迭代器里边获取下标元素
        CollectionUtils.get(new HashMap<>(),3);

        //是否是子集
        CollectionUtils.isProperSubCollection(objects,objects);

        //返回独一无二的元素已经他们的个数
        CollectionUtils.getCardinalityMap(new HashSet<>());
        CollectionUtils.subtract(objects,objects);

        Iterator<String> iterator = objects.iterator();




    }
}
