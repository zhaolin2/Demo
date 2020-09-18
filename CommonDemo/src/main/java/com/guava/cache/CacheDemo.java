package com.guava.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

/**
 * @author zl
 */
public class CacheDemo {
    public static void main(String[] args) {
        CacheDemo cacheDemo = new CacheDemo();
        Cache<String, String> cache = CacheBuilder.newBuilder().maximumSize(3).build();

        cache.put("k1", "v1");
        cache.put("k2", "v2");
        cache.put("k3", "v3");
        cache.put("k4", "v4");

        System.out.println(cache.size()); // 3
        System.out.println(cache.getIfPresent("k1")); // null
        System.out.println(cache.asMap()); // {k3=v3, k4=v4, k2=v2}
    }
}
