package com.javaee.netty;

import com.javaee.rpc.serialize.Hessian2Serialization;
import com.javaee.rpc.serialize.Serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @Description: 解码器
 * @Author: zl
 * @date: 2020/7/5
 */
public class RpcEncoder extends MessageToByteEncoder {

    private Class<?> genericClass;

    Serialization serialization = new Hessian2Serialization();

    public RpcEncoder(Class<?> genericClass) {
        this.genericClass = genericClass;
    }

    @Override
    public void encode(ChannelHandlerContext ctx, Object in, ByteBuf out) throws Exception {
        if (genericClass.isInstance(in)) {
            byte[] data = serialization.serialize(in);
            out.writeInt(data.length);
            out.writeBytes(data);
        }
    }
}
