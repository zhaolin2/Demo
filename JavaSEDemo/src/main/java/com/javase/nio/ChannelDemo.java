package com.javase.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zl
 * Channel只负责传输数据
 *   对于数据的操作都是通过缓冲区来进行的
 */
public class ChannelDemo {

    public static void main(String[] args) throws IOException {

        // 1. 通过本地IO的方式来获取通道
        FileInputStream fileInputStream = new FileInputStream("F:\\3yBlog\\JavaEE常用框架\\Elasticsearch就是这么简单.md");

        // 得到文件的输入通道
        FileChannel inchannel = fileInputStream.getChannel();

        // 2. jdk1.7后通过静态方法.open()获取通道
        FileChannel.open(Paths.get("F:\\3yBlog\\JavaEE常用框架\\Elasticsearch就是这么简单2.md"), StandardOpenOption.WRITE);

        //使用直接缓冲区完成文件复制
        FileChannel inChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get(""), StandardOpenOption.WRITE,StandardOpenOption.CREATE);

        //内存映射文件
        MappedByteBuffer inMappedBuff = inChannel.map(FileChannel.MapMode.READ_ONLY,0, inChannel.size());
        MappedByteBuffer outMappedBuff = outChannel.map(FileChannel.MapMode.READ_WRITE,0, outChannel.size());
        byte[] dst = new byte[inMappedBuff.limit()];

        //直接对缓冲区进行数据的读写操作
        inMappedBuff.get(dst);
        outMappedBuff.put(dst);

        inChannel.transferTo(0,inChannel.size(),outChannel);
        inChannel.close();
        outChannel.close();

        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024 * 10);

    }
}
