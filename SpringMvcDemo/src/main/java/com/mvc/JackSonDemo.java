package com.mvc;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mvc.jsonAnnotation.JackBean;

import java.io.IOException;

/**
 * @author zl
 */
public class JackSonDemo {
    public static void main(String[] args) throws IOException {

        JackSonDemo jackSonDemo = new JackSonDemo();
        jackSonDemo.stringToObject();
    }

    /**
     * readTree方法可以接受一个字符串或者字节数组、文件、InputStream等，
     * 返回JsonNode作为根节点，你可以像操作XML DOM那样操作遍历JsonNode以获取数据。
     */
    public void stringToObject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
//        try {
//            String json = "{\"name\":\"mrbird\",\"age\":26}";
//            JsonNode node = mapper.readTree(json);
//            String name = node.get("name").asText();
//            int age = node.get("age").asInt();
//            System.out.println(name + " " + age);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        //多级Tree解析
//        String json = "{\"name\":\"mrbird\",\"hobby\":{\"first\":\"sleep\",\"second\":\"eat\"}}";;
//        JsonNode node = mapper.readTree(json);
//        JsonNode hobby = node.get("hobby");
//        String first = hobby.get("first").asText();

        JackBean bean = new JackBean();
        bean.setName("123");
        bean.setPass("456");
        System.out.println(mapper.writeValueAsString(bean));
    }
}
