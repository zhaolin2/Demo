package com.javase.nio.nioSocket;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Locale;

/**
 * @author zl
 */
public class NioBlockClient {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        //得到文件
        FileChannel fileChannel = FileChannel.open(Paths.get(""), StandardOpenOption.READ);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024 * 10);

        while (fileChannel.read(byteBuffer)!=-1){
            byteBuffer.flip();

            socketChannel.write(byteBuffer);
            byteBuffer.clear();
        }

        socketChannel.close();

        //客户段接收

        int len=0;
        while ((len=socketChannel.read(byteBuffer))!=-1){
            byteBuffer.flip();
            System.out.println(new String(byteBuffer.array()));
            byteBuffer.clear();
        }

        fileChannel.close();
        socketChannel.close();
    }
}
