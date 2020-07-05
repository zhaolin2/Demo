package com.serialize;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.serialize.Serialization;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

/**
 * @Description: Kryo的序列化类
 * @Author: 赵
 * @date: 2020/7/5
 */
public class KryoSerialization implements Serialization {

    @Override
    public byte[] serialize(Object obj) {
        Kryo kryo = kryoLocal.get();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Output output = new Output(byteArrayOutputStream);//<1>
        kryo.writeClassAndObject(output, obj);//<2>
        output.close();
        return byteArrayOutputStream.toByteArray();
    }

    @Override
    public <T> T deserialize(byte[] bytes, Class<T> clz) {
        Kryo kryo = kryoLocal.get();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        Input input = new Input(byteArrayInputStream);
        input.close();

        return (T) kryo.readClassAndObject(input);
    }

    private static final ThreadLocal<Kryo> kryoLocal = new ThreadLocal<Kryo>() {//<3>
        @Override
        protected Kryo initialValue() {
            Kryo kryo = new Kryo();
            kryo.setReferences(true);// 默认值为 true, 强调作用
            kryo.setRegistrationRequired(false);// 默认值为 false, 强调作用
            return kryo;
        }
    };
}
