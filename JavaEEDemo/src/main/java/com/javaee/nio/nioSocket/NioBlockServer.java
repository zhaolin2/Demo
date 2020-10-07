package com.javaee.nio.nioSocket;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author zl
 */
public class NioBlockServer {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 2.得到文件通道，将客户端传递过来的图片写到本地项目下(写模式、没有则创建)
        FileChannel outChannel = FileChannel.open(Paths.get("2.png"), StandardOpenOption.WRITE, StandardOpenOption.CREATE);

        serverSocketChannel.bind(new InetSocketAddress(6379));

        SocketChannel clientChannel = serverSocketChannel.accept();

        ByteBuffer buffer = ByteBuffer.allocate(1024 * 10);

        while (clientChannel.read(buffer)!=0){
            buffer.flip();

            outChannel.write(buffer);
            buffer.clear();
        }

        buffer.put("sucess".getBytes());
        buffer.flip();
        clientChannel.write(buffer);
        buffer.clear();

        outChannel.close();
        clientChannel.close();
        serverSocketChannel.close();

    }
}
