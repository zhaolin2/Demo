package com.javaee.nio.nioSocket;

import javafx.concurrent.Worker;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.logging.Logger;

public class NIOClient {

    static private Logger log=Logger.getLogger(NIOClient.class.getName());


    public static void main(String[] args) {

            new Worker().start();

    }

    static class Worker extends Thread {
        @Override
        public void run() {
            SocketChannel channel = null;
            Selector selector = null;
            try {
                channel = SocketChannel.open();
                channel.configureBlocking(false);

                selector = Selector.open();
                channel.register(selector, SelectionKey.OP_CONNECT);
                channel.connect(new InetSocketAddress(9000));
                while (true) {
                    selector.select();
                    Iterator<SelectionKey> keysIterator = selector.selectedKeys().iterator();
                    while (keysIterator.hasNext()) {
                        SelectionKey key = keysIterator.next();
                        keysIterator.remove();

                        if (key.isConnectable()) {
                            System.out.println();
                            channel = (SocketChannel) key.channel();

                            if (channel.isConnectionPending()) {
                                channel.finishConnect();

                                ByteBuffer buffer = ByteBuffer.allocate(1024);
                                buffer.put("你好".getBytes());
                                buffer.flip();
                                channel.write(buffer);
                            }

                            channel.register(selector, SelectionKey.OP_READ);
                        }

                        if (key.isReadable()) {
                            channel = (SocketChannel) key.channel();
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            int len = channel.read(buffer);

                            if (len > 0) {
                                log.info("[" + Thread.currentThread().getName()
                                        + "]收到响应：" + new String(buffer.array(), 0, len));
                                Thread.sleep(5000);
                                channel.register(selector, SelectionKey.OP_WRITE);
                            }
                        }

                        if(key.isWritable()) {
                            ByteBuffer buffer = ByteBuffer.allocate(1024);
                            buffer.put("你好".getBytes());
                            buffer.flip();

                            channel = (SocketChannel) key.channel();
                            channel.write(buffer);
                            channel.register(selector, SelectionKey.OP_READ);
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally{
                if(channel != null){
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(selector != null){
                    try {
                        selector.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

}
