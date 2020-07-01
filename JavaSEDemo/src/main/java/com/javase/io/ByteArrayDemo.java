package com.javase.io;

import java.io.*;

/**
 * @author zl
 */
public class ByteArrayDemo {

    public static void main(String[] args) throws IOException {

        String str = "ROLLENHOLT";
        ByteArrayInputStream input = new ByteArrayInputStream(str.getBytes());
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        int temp = 0;
        while ((temp = input.read()) != -1) {
            char ch = (char) temp;
            output.write(Character.toLowerCase(ch));
        }
        String outStr = output.toString();
        input.close();
        output.close();
        System.out.println(outStr);

        //流在使用结束后，一定要执行关闭操作，即调用close( )方法。

    }
}
