package com.middle.kafka;

import org.apache.kafka.clients.producer.ProducerInterceptor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import java.util.Map;

/**
 * @author zl
 * configure(configs)：获取配置信息和初始化数据时调用；
 * onSend(ProducerRecord)：在消息被序列化以及计算分区前调用该方法。用户可以在该方法中对消息做任何操作，但最好不要修改消息所属的 topic 和分区，否则会影响目标分区的计算；
 *
 * onAcknowledgement(RecordMetadata, Exception)：在返回ack时，或者发送失败时调用该方法。
 *
 * close：关闭 interceptor，主要用于执行一些资源清理工作。
 */
public class MessageFormatInterceptor implements ProducerInterceptor<String, String> {

    @Override
    public ProducerRecord<String, String> onSend(ProducerRecord<String, String> record) {
        return new ProducerRecord<>(record.topic(), record.partition(), record.timestamp(), record.key(),
                System.currentTimeMillis() + " - " + record.value());
    }

    @Override
    public void onAcknowledgement(RecordMetadata metadata, Exception exception) {

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
