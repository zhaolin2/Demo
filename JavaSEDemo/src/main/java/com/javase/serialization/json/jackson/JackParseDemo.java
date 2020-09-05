package com.javase.serialization.json.jackson;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.javase.serialization.json.Person;

import java.io.IOException;

/**
 * @Description:解析示例
 * @Author: zl
 * @date: 2020/8/7
 */
public class JackParseDemo {

    public static void main(String[] args) throws IOException {
        String jsonStr = "{\"name\":\"YourBatman\",\"age\":18}";
        Person pearson = new Person();

        JsonFactory factory = new JsonFactory();
        try (JsonParser jsonParser = factory.createParser(jsonStr)) {

            // 只要还没结束"}"，就一直读
            while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                String fieldname = jsonParser.getCurrentName();
                if ("name".equals(fieldname)) {
                    jsonParser.nextToken();
                    pearson.setName(jsonParser.getText());
                } else if ("age".equals(fieldname)) {
                    jsonParser.nextToken();
                    pearson.setAge(jsonParser.getIntValue());
                }

                // value值不对的时候  会抛出异常
                jsonParser.getText();
                jsonParser.getNumberValue();
                jsonParser.getIntValue();
                jsonParser.getLongValue();

                //会有默认值 不会抛出异常
                jsonParser.getValueAsString("123");
            }

            System.out.println(pearson);
        }
    }
}
