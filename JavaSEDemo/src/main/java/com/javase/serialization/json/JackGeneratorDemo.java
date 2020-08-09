package com.javase.serialization.json;


import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

import java.io.IOException;
import java.io.PrintStream;

/**
 * @Description:jack的序列化
 * @Author: zl
 * @date: 2020/8/3
 */
public class JackGeneratorDemo {

    public static void main(String[] args) {

        JackGeneratorDemo jackGeneratorDemo = new JackGeneratorDemo();

        JsonFactory factory = new JsonFactory();
        try (PrintStream err = System.err; JsonGenerator jg = factory.createGenerator(err, JsonEncoding.UTF8)) {
            // 特征置为false 采用手动关流的方式
            jg.disable(JsonGenerator.Feature.AUTO_CLOSE_TARGET);

            // doSomething
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void writeField() throws IOException {
//        JsonFactory factory = new JsonFactory();
//        // 本处只需演示，向控制台写（当然你可以向文件等任意地方写都是可以的）
//        JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8);
//
//        try {
//            jsonGenerator.writeStartObject(); //开始写，也就是这个符号 {
//
//            jsonGenerator.writeStringField("name", "YourBatman");
//            jsonGenerator.writeNumberField("age", 18);
//
//            jsonGenerator.writeEndObject(); //结束写，也就是这个符号 }
//        } finally {
//            jsonGenerator.close();
//        }


        JsonFactory factory = new JsonFactory();
        // 本处只需演示，向控制台写（当然你可以向文件等任意地方写都是可以的）
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject(); //开始写，也就是这个符号 {

            jsonGenerator.writeStringField("name", "YourBatman");
            jsonGenerator.writeNumberField("age", 18);

            jsonGenerator.writeEndObject(); //结束写，也就是这个符号 }
        }
    }


    public void writeObjectByStep() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName("zhName");

            jsonGenerator.writeEndObject();
        }
    }


    public void WriteObjByStep() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName("zhName");
            jsonGenerator.writeString("A哥");

            jsonGenerator.writeFieldName("enName");
            jsonGenerator.writeString("YourBatman");

            jsonGenerator.writeEndObject();
        }
    }


    public void writeComplexObject() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName("zhName");
            jsonGenerator.writeString("A哥");

            // 写对象（记得先写key 否则无效）
            jsonGenerator.writeFieldName("person");
            jsonGenerator.writeStartObject();
            jsonGenerator.writeFieldName("enName");
            jsonGenerator.writeString("YourBatman");
            jsonGenerator.writeFieldName("age");
            jsonGenerator.writeNumber(18);
            jsonGenerator.writeEndObject();

            jsonGenerator.writeEndObject();
        }
    }


    public void writeArray() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName("zhName");
            jsonGenerator.writeString("A哥");

            // 写数组（记得先写key 否则无效）
            jsonGenerator.writeFieldName("objects");
            jsonGenerator.writeStartArray();
            // 1、写字符串
            jsonGenerator.writeString("YourBatman");
            // 2、写对象
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("enName", "YourBatman");
            jsonGenerator.writeEndObject();
            // 3、写数字
            jsonGenerator.writeNumber(18);
            jsonGenerator.writeEndArray();

            jsonGenerator.writeEndObject();
        }
    }


    public void writeFieldAndArr() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName("zhName");
            jsonGenerator.writeString("A哥");

            // 快捷写入数组（从第index = 2位开始，取3个）
            jsonGenerator.writeFieldName("values");
            jsonGenerator.writeArray(new int[]{1, 2, 3, 4, 5, 6}, 2, 3);

            jsonGenerator.writeEndObject();
        }
    }


    public void writeNullField() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeFieldName("success");
            jsonGenerator.writeBoolean(true);
            jsonGenerator.writeFieldName("myName");
            jsonGenerator.writeNull();

            jsonGenerator.writeEndObject();
        }
    }

    public void writeFieldValue() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeStartObject();

            jsonGenerator.writeStringField("zhName","A哥");
            jsonGenerator.writeBooleanField("success",true);
            jsonGenerator.writeNullField("myName");
            // jsonGenerator.writeObjectFieldStart();
            // jsonGenerator.writeArrayFieldStart();

            jsonGenerator.writeEndObject();
        }
    }



    public void test9() throws IOException {
        JsonFactory factory = new JsonFactory();
        try (JsonGenerator jsonGenerator = factory.createGenerator(System.out, JsonEncoding.UTF8)) {
            jsonGenerator.writeString("{'name':'YourBatman'}");
            jsonGenerator.writeRaw("{'name':'YourBatman'}");
        }
    }

}
