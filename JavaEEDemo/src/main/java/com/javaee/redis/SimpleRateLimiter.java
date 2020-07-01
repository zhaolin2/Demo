package com.javaee.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;
import redis.clients.jedis.Response;

import java.io.IOException;

public class SimpleRateLimiter {

    private Jedis jedis;

    public SimpleRateLimiter(Jedis jedis) {
        this.jedis = jedis;
    }

    public boolean isActionAllowed(String userId, String actionKey, int period, int maxCount) throws IOException {
        String key = String.format("hist:%s:%s", userId, actionKey);
        long nowTs = System.currentTimeMillis();
        Pipeline pipe = jedis.pipelined();
        // 用了multi，也就是事务，能保证一系列指令的原子顺序执行
        pipe.multi();
        // value 和 score 都使用毫秒时间戳
        pipe.zadd(key, nowTs, "" + nowTs);
        // 移除时间窗口之前的行为记录，剩下的都是时间窗口内的
        pipe.zremrangeByScore(key, 0, nowTs - period * 1000);
        // 获取窗口内的行为数量
        Response<Long> count = pipe.zcard(key);
        // 设置 zset 过期时间，避免冷用户持续占用内存  过期时间应该等于时间窗口的长度，再多宽限 1s
        pipe.expire(key, period + 1);
        pipe.exec();
        pipe.close();
        return count.get() <= maxCount;
    }

    public static void main(String[] args) throws IOException {
        Jedis jedis = new Jedis();
        SimpleRateLimiter limiter = new SimpleRateLimiter(jedis);
        for(int i=0;i<200;i++) {
            System.out.println(limiter.isActionAllowed("laoqian132", "reply", 60, 5));
        }
    }
}
