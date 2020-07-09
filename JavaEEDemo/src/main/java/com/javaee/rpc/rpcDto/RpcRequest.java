package com.javaee.rpc.rpcDto;

import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @Description: 远程请求的Request
 * @Author: zl
 * @date: 2020/7/5
 */
@Data
public class RpcRequest implements Serializable {
    private String interfaceName;
    private String methodName;
    private String parametersDesc;
    private Object[] arguments;
    private Map<String, String> attachments;
    private int retries = 0;
    private long requestId;
    private byte rpcProtocolVersion;
}
