package com.serialize;

import java.io.IOException;

/**
 * @Description:序列化接口
 * @Author: 赵
 * @date: 2020/7/5
 * 主要有下边几个实现和特点
 * {@link com.serialize.FastJsonSerialization} 作为文本型 无法比较
 * {@link com.serialize.Hessian2Serialization}  跨语言 字节数适中
 * {@link com.serialize.KryoSerialization}  字节数最小 无法跨语言
 * {@link com.serialize.ProtostuffSerialization}
 */
public interface Serialization {

    byte[] serialize(Object obj) throws IOException;

    <T> T deserialize(byte[] bytes, Class<T> clz) throws IOException;
}
