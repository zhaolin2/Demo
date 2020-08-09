package com.middle.redis;

import com.sun.deploy.util.StringUtils;
import io.netty.util.internal.StringUtil;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.Arrays;
import java.util.List;

/**
 * @Description: redis测试类
 * @Author: 敖丙
 * @date: 2020-05-10
 **/
public class RedisDemo {

    static Jedis redis = new JedisPool("127.0.0.1", 6379).getResource();

    final static List<Integer> mysql = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public static void main(String[] args) {
        // 查询请求进来
        Integer id = -1;

        // 查询缓存
        String aobing = redis.get(id.toString());
        if (aobing == null) {
            System.out.println(aobing);
            return;
        }

        // 第三方缓存


        // 查询数据库
        if (mysql.contains(id)) {
            System.out.println("在数据库 id:" + id);

            redis.set(id.toString(), "xxx");
            return;
        }

        System.out.println("不在数据库 set redis");
        return;
    }
}
