package com.javase.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * @author zl
 */
public class SystemToFile {
    public static void main(String[] args) {
        File file = new File("D:"+File.separator+"temp"+File.separator+"hello.txt");
        // 此刻直接输出到屏幕
        System.out.println("hello");
        try {
            System.setOut(new PrintStream(new FileOutputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("这些内容在文件中才能看到哦！");
    }
}
