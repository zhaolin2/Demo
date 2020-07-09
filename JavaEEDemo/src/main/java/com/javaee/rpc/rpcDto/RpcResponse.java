package com.javaee.rpc.rpcDto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description: 远程请求的Response
 * @Author: zl
 * @date: 2020/7/5
 */
@Data
public class RpcResponse implements Serializable {
    private Object value;
    private Exception exception;
    private long requestId;
    private long processTime;
    private int timeout;
    // rpc 协议版本兼容时可以回传一些额外的信息
    private Map<String, String> attachments;
    private byte rpcProtocolVersion;
}
