package com.javase.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @Description: 把System.in 转入到buffer中读取
 * @Author: zl
 * @date: 2020/7/7
 */
public class BufferReaderBySystemin {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line=bufferedReader.readLine() )!=null){
            System.out.println(line);
        }

        int i=0;
        do {
            i++;
        }while (i<5);

        bufferedReader.close();
    }
}
