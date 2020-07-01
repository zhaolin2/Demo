package com.javase.thread.callable;

public class FutureClient {
    public Data request(String requestData){
        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            @Override
            public void run() {
                //产生阻塞
                RealData realData = new RealData("6464");
                futureData.setRequestData(realData);
            }
        }).start();
        return futureData;
    }
}
