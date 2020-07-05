package com.javaee.rpc.serialize;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.Schema;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.objenesis.Objenesis;
import org.objenesis.ObjenesisStd;

import java.io.IOException;

/**
 * @Description:Protostuff的序列化
 * @Author: zl
 * @date: 2020/7/5
 */
public class ProtostuffSerialization implements Serialization {

    @Override
    public byte[] serialize(Object obj) throws IOException {
        Class clz = obj.getClass();
        LinkedBuffer buffer = LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE);
        try {
            Schema schema = RuntimeSchema.createFrom(clz);
            return ProtostuffIOUtil.toByteArray(obj, schema, buffer);
        } catch (Exception e) {
            throw e;
        } finally {
            buffer.clear();
        }
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clz) throws IOException {
        T message = objenesis.newInstance(clz);
        Schema<T> schema = RuntimeSchema.createFrom(clz);
        ProtostuffIOUtil.mergeFrom(bytes, message, schema);
        return message;
    }

    private Objenesis objenesis = new ObjenesisStd();



}
