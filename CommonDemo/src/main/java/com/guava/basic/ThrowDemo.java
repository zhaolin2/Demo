package com.guava.basic;

import com.google.common.base.Throwables;

import java.io.File;
import java.io.IOException;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/17
 */
public class ThrowDemo {
    public static void main(String[] args) throws IOException {

        File file = new File("test");
        file.exists();
        IOException ioException = new IOException();
        Throwables.getStackTraceAsString(ioException);
        Throwables.getRootCause(ioException);
        Throwables.getCausalChain(ioException);
    }
}
