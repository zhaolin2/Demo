package com.javaee.nio;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * Buffer 内存缓冲区，本质就是一块内存，只是把这块内存封装为NIO Buffer，提供一些常用的方法来进行读写
 *
 * 也可以理解为一个封装之后的数组{@link ByteBuffer} 可以理解为byte[]
 * @author zl
 * ByteBuffDemo
 * 容量Capacity
 *
 * 缓冲区能够容纳的数据元素的最大数量。容量在缓冲区创建时被设定，并且永远不能被改变。(不能被改变的原因也很简单，底层是数组嘛)
 *
 * 上界Limit
 *          缓冲区里的数据的总数，代表了当前缓冲区中一共有多少数据。
 *
 * 位置Position
 *          下一个要被读或写的元素的位置。Position会自动由相应的 get( )和 put( )函数更新。
 *
 * 标记Mark
 *      一个备忘位置。用于记录上一次读写的位置。
 */
public class ByteBuffDemo {


    public static void main(String[] args) {
        // 创建一个缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        ByteBuffer.wrap("test".getBytes(StandardCharsets.UTF_8));
        ByteBuffer.allocateDirect(1024);

        // 看一下初始时4个核心变量的值
        System.out.println("初始时-->limit--->"+byteBuffer.limit());
        System.out.println("初始时-->position--->"+byteBuffer.position());
        System.out.println("初始时-->capacity--->"+byteBuffer.capacity());
        System.out.println("初始时-->mark--->" + byteBuffer.mark());

        System.out.println("--------------------------------------");

        // 添加一些数据到缓冲区中
        String s = "Java3y";
        byteBuffer.put(s.getBytes());


        // 看一下初始时4个核心变量的值
        System.out.println("put完之后-->limit--->"+byteBuffer.limit());
        System.out.println("put完之后-->position--->"+byteBuffer.position());
        System.out.println("put完之后-->capacity--->"+byteBuffer.capacity());
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());

        //切换到读模式
        byteBuffer.flip();

        // 看一下初始时4个核心变量的值
        System.out.println("put完之后-->limit--->"+byteBuffer.limit());
        System.out.println("put完之后-->position--->"+byteBuffer.position());
        System.out.println("put完之后-->capacity--->"+byteBuffer.capacity());
        System.out.println("put完之后-->mark--->" + byteBuffer.mark());

        // 创建一个limit()大小的字节数组(因为就只有limit这么多个数据可读)
        byte[] bytes = new byte[byteBuffer.limit()];

        // 将读取的数据装进我们的字节数组中
        byteBuffer.get(bytes);

        // 输出数据
        System.out.println(new String(bytes, 0, bytes.length));

        byteBuffer.clear();

        //对buffer的重复读
        byteBuffer.rewind();

        //mark()方法是保存当前position到变量mark中
        byteBuffer.mark();
        //然后通过reset()方法恢复当前position为mark
        byteBuffer.reset();
    }
}
