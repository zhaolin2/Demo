package com.sinozo.jackson.databind;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.sinozo.jackson.entity.Person;

import java.io.IOException;
import java.util.List;

/**
 * 高层抽象 底层依赖stream api来实现
 * 读取和写入json的功能
 * 可以使用特征来进行高度定制化
 * 支持多态泛型 对象标识
 *
 * objectmapper可以处理xml json
 * jsonmapper只能处理json格式的映射
 *
 * 特征值较多
 * https://blog.csdn.net/f641385712/article/details/103792641
 */
public class ObjectMappeDemo {

    private static ObjectMapper objectMapper = new ObjectMapper();

    //专门处理json
    private static JsonMapper jsonMapper = new JsonMapper();

    public static void main(String[] args) throws IOException {

    }

    /**
     * 普通的javabean是可以的 那么List等集合类也是可以的
     * @throws IOException
     */
    private void readBean() throws IOException {
        Person person = objectMapper.readValue("", Person.class);

    }

    private void writeBean() throws JsonProcessingException {
        Person writePerson = new Person();
        writePerson.setAge(14).setName("test");
        String write = objectMapper.writeValueAsString(writePerson);
    }

    /**
     * list等泛型集合类的过程中 会擦除泛型的信息 所以在序列化的过程中会无法获取集合中的泛型信息
     * 1.泛型类 接口 方法 成员变量的时候会保留泛型信息，所以可以使用这些来保存需要序列化的泛型信息
     * 2.使用TypeReference<T>来进行保存
     */
    private void typeHandlerJson() throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        String idsStr = "[1,2,3]";

        List<Long> list = objectMapper.readValue(idsStr, new TypeReference<List<Long>>() {});
        Long i1 = list.get(0);
        System.out.println(list);

    }
}
