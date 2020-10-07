package com.javase.designPattern.singlenton.lazy;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/2
 */
public class CasSingleton {

    private static AtomicReference<CasSingleton> INSTANCE = new AtomicReference<>();

    public CasSingleton getInstance(){
        for (;;){
            CasSingleton instance = CasSingleton.INSTANCE.get();

            if (instance != null){
                return instance;
            }

            instance = new CasSingleton();
            if (INSTANCE.compareAndSet(null, instance)){
                return instance;
            }

        }
    }
}
