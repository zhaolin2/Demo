package com.guava.basic;

import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.checkerframework.checker.nullness.qual.Nullable;

import javax.sound.midi.SoundbankResource;
import java.util.ArrayList;

/**
 * 排序器应该从后往前读
 * 因为每次调用都是使用后边的方法包装了前边的方法
 */
public class OrderDemo {
    public static void main(String[] args) {

        ArrayList<ComPareDomain> domainList = Lists.newArrayList();
        domainList.add(new ComPareDomain().setName("domain"));
        domainList.add(new ComPareDomain().setName("main"));
        domainList.add(new ComPareDomain().setName("ain"));

        Ordering<ComPareDomain> comPareDomainOrdering = Ordering.natural().nullsLast()
                .onResultOf(new Function<ComPareDomain, String>() {
            @Nullable
            @Override
            public String apply(@Nullable ComPareDomain comPareDomain) {
                assert comPareDomain != null;
                return comPareDomain.name;
            }
        });
        ComPareDomain max = comPareDomainOrdering.max(domainList);
        System.out.println(max);

        comPareDomainOrdering.greatestOf(domainList,10);
        comPareDomainOrdering.leastOf(domainList,10);


    }
}
