package com.jackson.feature;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;

/**
 * @Description:json的特征值demo
 * @Author: zl
 * @date: 2020/8/7
 */
public class JackGeneratorFearureDemo {
    public static void main(String[] args) throws IOException {
        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(System.out, JsonEncoding.UTF8);

        //特征值置为false 要手动关闭流
        generator.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);

        //自动闭合JSON串，即只写startObject 不需要写end
        generator.disable(JsonGenerator.Feature.AUTO_CLOSE_JSON_CONTENT);

        //需要自己刷新并关闭缓冲区
        generator.disable(JsonGenerator.Feature.FLUSH_PASSED_TO_STREAM);
//        generator.flush();
//        generator.close();

        // field是否使用 " " 括起来
        generator.disable(JsonGenerator.Feature.QUOTE_FIELD_NAMES);
//        JsonWriteFeature.QUOTE_FIELD_NAMES;


        //true：使用BigDecimal#toPlainString()方法输出
        //false： 使用默认输出方式（取决于BigDecimal是如何构造的）
        generator.disable(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN);

        //是否严格检测重复属性名
        generator.enable(JsonGenerator.Feature.STRICT_DUPLICATE_DETECTION);

        generator.setSchema(new FormatSchema() {
            @Override
            public String getSchemaType() {
                return null;
            }
        });

//        generator.setPrettyPrinter();
    }
}
