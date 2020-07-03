package com.middle.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * @author zl
 */
public class ConsumerDemo {

    public static void main(String[] args) throws InterruptedException {
        // 1. 消费者配置
        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        // 自动提交offset
        properties.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, true);
        // 提交offset的时间，单位ms，即1秒钟提交一次
        properties.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, "1000");
        // 指定k-v反序列化规则
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringDeserializer");
        // 指定消费者组
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group");

        // 2. 创建消费者
        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(properties);
        // 订阅主题
        consumer.subscribe(Collections.singletonList("test"));
        while (true){
            // 拉取数据，指定轮询时间为1秒
            ConsumerRecords<String, String> consumerRecords = consumer.poll(Duration.ofSeconds(1));
            for (ConsumerRecord<String, String> consumerRecord : consumerRecords) {
                System.out.println(consumerRecord.toString());
            }
            // 异步提交
//            consumer.commitAsync();

            consumer.commitAsync((offsets, exception) -> {
                if (exception == null) {
                    System.out.println("提交offset: " + offsets + "成功");
                } else {
                    System.out.println("提交失败");
                    exception.printStackTrace();
                }

//            TimeUnit.SECONDS.sleep(1);
                });
        }
    }
}
