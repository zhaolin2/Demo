package com.javase.serialization.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.javase.serialization.Person;

import java.util.List;

/**
 * @Description:Gson序列化的demo
 * @Author: zl
 * @date: 2020/8/3
 */
public class GsonDemo {
    public static void main(String[] args) {
        Gson gson = new Gson();
        Person person = gson.fromJson("{\"age\":12,\"name\":\"213\"}", Person.class);

        Person gsonPearson = new Person().setAge(14).setName("35");
        String s = gson.toJson(gsonPearson);
//        System.out.println(s);

        //解析为list
        String jsonArray = "[\"Android\",\"Java\",\"PHP\"]";
        String[] strings = gson.fromJson(jsonArray, String[].class);
        List<String> stringList = gson.fromJson(jsonArray, new TypeToken<List<String>>() {}.getType());

//        JsonElement jsonElement = gson.toJsonTree(gsonPearson);
//        String string = jsonElement.toString();
//        System.out.println(string);

        Gson buildGson = gson.newBuilder()
                //序列化null
                .serializeNulls()
                // 设置日期时间格式，另有2个重载方法
                // 在序列化和反序化时均生效
                .setDateFormat("yyyy-MM-dd")
                // 禁此序列化内部类
                .disableInnerClassSerialization()
                //生成不可执行的Json（多了 )]}' 这4个字符）
                .generateNonExecutableJson()
                //禁止转义html标签
                .disableHtmlEscaping()
                //格式化输出
                .setPrettyPrinting()
                .create();


    }
}
