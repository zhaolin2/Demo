package com.sinozo.guava.basic;

import com.google.common.collect.ComparisonChain;
import lombok.Data;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@Data
public class ComPareDomain implements Comparable {
    String name;
    Integer age;

    Double price;

    @Override
    public int compareTo(Object o) {
        int res = 0;
        if (o instanceof ComPareDomain){
            /**
             * 比较器链
             */
            ComPareDomain cast = ComPareDomain.class.cast(o);
            res = ComparisonChain.start()
                    .compare(this.name, cast.name)
                    .result();
        }

        return res;
    }
}
