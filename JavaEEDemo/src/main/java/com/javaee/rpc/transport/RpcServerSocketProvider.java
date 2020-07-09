package com.javaee.rpc.transport;

import com.javaee.rpc.rpcDto.RpcRequest;
import com.javaee.rpc.rpcDto.RpcResponse;
import com.javaee.rpc.serialize.Hessian2Serialization;
import com.javaee.rpc.serialize.Serialization;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:远程调用的提供端
 * @Author: zl
 * @date: 2020/7/5
 */
public class RpcServerSocketProvider {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8088);
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 序列化层实现参考之前的章节
        Serialization serialization = new Hessian2Serialization();

        while (true){
            Socket socket = serverSocket.accept();

            executorService.execute(()->{

                try {
                    InputStream inputStream = socket.getInputStream();
                    OutputStream outputStream = socket.getOutputStream();

                    DataInputStream dataInputStream = new DataInputStream(inputStream);
                    int len = dataInputStream.readInt();
                    byte[] requestBody = new byte[len];
                    dataInputStream.read(requestBody);

                    RpcRequest rpcRequest = serialization.deserialize(requestBody, RpcRequest.class);
                    RpcResponse rpcResponse = invoke(rpcRequest);

                    byte[] responseBody = serialization.serialize(rpcResponse);

                    DataOutputStream dos = new DataOutputStream(outputStream);
                    dos.writeInt(responseBody.length);
                    dos.write(responseBody);
                    dos.flush();
                }catch (IOException e){
                    e.printStackTrace();
                }finally {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }


            });


        }
    }

    public static RpcResponse invoke(RpcRequest rpcRequest) {
        // 模拟反射调用
        RpcResponse rpcResponse = new RpcResponse();
        rpcResponse.setRequestId(rpcRequest.getRequestId());
        //... some operation
        return rpcResponse;
    }
}
