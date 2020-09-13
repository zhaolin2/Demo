package com.javase.log;

import java.util.logging.Logger;

/**
 * 除了jdk自带的之外
 * 也可以用commons-log接口
 * 或者self4j来作为接口，使用log-back来作为实现
 *
 */
public class JDKLoggingDemo {
    /**
     * jdk自带的打印日志
     */
    static private Logger logger=Logger.getLogger(JDKLoggingDemo.class.getName());
    public static void main(String[] args) {
        logger.info("test");
    }
}
