package com.javase.thread.callable;

public class RealData extends Data{
    private String requestResult;
    public RealData(String requestData){
        System.out.println("正在使用data进行网络请求，data"+requestData+"开始。。。");
        try {
            //业务操作耗时
            Thread.sleep(3000);
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("操作执行完毕 获取到结果");
        //获取返回结果
        this.requestResult="鱼鱼鱼";
    }
    @Override
    public String getRequest() {
        return requestResult;
    }
}
