package com.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.annotations.VisibleForTesting;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/8/16
 */
public class JacksonTest {

    @Test
    public void objectMapperTest() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("123");
        arrayList.add("2321");
        int[] a=new int[6];
        a[1]=1;
        a[2]=4;
        String string = objectMapper.writeValueAsString(a);
        System.out.println(string);
    }
}
