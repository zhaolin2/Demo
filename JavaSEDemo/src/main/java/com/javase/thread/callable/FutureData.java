package com.javase.thread.callable;

public class FutureData extends Data {

    //读取结果 false表示没有获取到
    private boolean FLAG=false;
    private RealData realData;
    //读取data数据
    synchronized public void setRequestData(RealData realData){
        //如果获取到结果 直接返回
        if(FLAG){
            return;
        }
        //false 传递ReadData
        this.realData=realData;
        FLAG=true;
        notify();
    }
    @Override
    synchronized public String getRequest() {
        while (!FLAG){
            try {
                wait();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return realData.getRequest();
    }
}
