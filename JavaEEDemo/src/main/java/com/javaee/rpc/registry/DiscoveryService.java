package com.javaee.rpc.registry;

import java.util.List;

/**
 * @Description: 服务注册接口
 * @Author: zl
 * @date: 2020/7/5
 */
public interface DiscoveryService {

    //1. 订阅服务
//    void subscribe(URL url, NotifyListener listener);
    //2. 取消订阅
//    void unsubscribe(URL url, NotifyListener listener);
    //3. 发现服务列表
    List<URL> discover(URL url);
}
