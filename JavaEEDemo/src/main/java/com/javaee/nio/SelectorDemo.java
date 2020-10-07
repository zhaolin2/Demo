package com.javaee.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Connect:仅适用于客户端，对应 {@link SelectionKey#OP_CONNECT}
 * Accept: 接收新的连接事件， {@link SelectionKey#OP_ACCEPT}
 * 选择器
 */
public class SelectorDemo {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
          serverSocketChannel.configureBlocking(false);
          serverSocketChannel.register(selector, SelectionKey.OP_READ | SelectionKey.OP_ACCEPT);
        }

        //阻塞，等待channel准备就绪之后才会返回
        selector.select();
        //不会产生阻塞，立马返回
        selector.selectNow();


    }
}
