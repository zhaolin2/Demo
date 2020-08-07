package com.javase.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiMain {
    public static void main(String[] args) {

        Iterator<SpiService> providers = Service.providers(SpiService.class);
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);

        while(providers.hasNext()) {
            SpiService ser = providers.next();
            ser.test();
        }
        System.out.println("--------------------------------");
        for (SpiService ser : load) {
            ser.test();
        }
    }
}
