package com.javaee.rpc.registry;

import java.util.Map;

/**
 * @Description: 作为参数来进行传递
 * @Author: zl
 * @date: 2020/7/5
 */
public class URL {

    private String protocol;// 协议名称
    private String host;
    private int port;
    // interfaceName, 也代表着路径
    private String path;
    private Map<String, String> parameters;
    private volatile transient Map<String, Number> numbers;
}
