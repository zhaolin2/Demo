package com.javase.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author zl
 */
public class RandomAccessDemo {

    public static void main(String[] args) throws IOException {

        byte[] bytes = new byte[1024];
        RandomAccessFile r = new RandomAccessFile(new File("D:\\temp\\hello.txt"), "r");

        System.out.println(new String(r.readLine().getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8));

        r.seek(r.getFilePointer());
//        System.out.println(r.getFilePointer());
        r.read(bytes, 0, 4);
        byte[] copyByte= Arrays.copyOf(bytes,4);
        System.out.println(new String(copyByte,StandardCharsets.ISO_8859_1));
//        r.read(bytes, 0, 4);
//        System.out.println(new String(bytes,StandardCharsets.UTF_8));
//        r.read(bytes, 0, 4);
//        System.out.println(new String(bytes,StandardCharsets.UTF_8));

    }
}
