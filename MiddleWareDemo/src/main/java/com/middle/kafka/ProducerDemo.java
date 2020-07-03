package com.middle.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author zl
 */
public class ProducerDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 1. 生产者配置
        Properties properties = new Properties();
//        // 指定自定义分区器
//        properties.put(ProducerConfig.PARTITIONER_CLASS_CONFIG, MyPartitioner.class);

        // 指定过滤器链
        properties.put(ProducerConfig.INTERCEPTOR_CLASSES_CONFIG, Arrays.asList("com.demo.MessageFormatInterceptor", "com.demo.CountInterceptor"));




        // 指定kafka地址
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        // 指定ack等级
        properties.put(ProducerConfig.ACKS_CONFIG, "all");
        // 指定重试次数，即生产者发送数据后没有收到ack应答时的重试次数
        properties.put(ProducerConfig.RETRIES_CONFIG, 3);
        // 指定批次大小 16k = 16 * 1024
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG, 16384);
        // 指定等待时间，单位毫秒
        properties.put(ProducerConfig.LINGER_MS_CONFIG, 10);
        // 指定RecordAccumulator缓冲区大小 32m = 32 * 1024 * 1024
        properties.put(ProducerConfig.BUFFER_MEMORY_CONFIG, 33554432);
        // 指定k-v序列化规则
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.StringSerializer");
        // 2. 创建生产者
        KafkaProducer<String, String> producer = new KafkaProducer<>(properties);
//        // 3. 准备数据
//        ProducerRecord<String, String> record = new ProducerRecord<>("test", "mesage");
//        // 4. 发送数据（不带回调）
//        producer.send(record);

//        // 3. 准备数据
//        ProducerRecord<String, String> record = new ProducerRecord<>("test", "callback-test");
//        // 4. 发送数据（带回调）
//        producer.send(record, (metadata, exception) -> {
//            if (exception == null) {
//                // 回调函数，该方法会在 Producer 收到 ack 时调用，为异步调用
//                String result = String.format("消息发送成功，主题Topic: %s,分区Partition: %s,偏移量Offset: %s",
//                        metadata.topic(), metadata.partition(), metadata.offset());
//                System.out.println(result);
//            } else {
//                System.out.println("消息发送失败");
//                exception.printStackTrace();
//            }
//
//        });

        // 3. 准备数据
        ProducerRecord<String, String> record = new ProducerRecord<>("test", "test-sync");
        // 4. 发送数据（带回调）
        Future<RecordMetadata> future = producer.send(record, (metadata, exception) -> {
            if (exception == null) {
                // 回调函数，该方法会在 Producer 收到 ack 时调用，为异步调用
                String result = String.format("消息发送成功，主题Topic: %s,分区Partition: %s,偏移量Offset: %s",
                        metadata.topic(), metadata.partition(), metadata.offset());
                System.out.println(result);
            } else {
                System.out.println("消息发送失败");
                exception.printStackTrace();
            }

        });
        //转化为同步
        future.get();

        // 5. 关闭连接
        producer.close();
    }
}
