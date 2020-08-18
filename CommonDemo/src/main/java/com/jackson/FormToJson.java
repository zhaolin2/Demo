package com.jackson;

import com.fasterxml.jackson.core.FormatSchema;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.PrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description:根据form表单的数据来生成json
 * @Author: zl
 * @date: 2020/8/16
 */
public class FormToJson {

    static String formString = "";
    static String stepJson = "{\n" +
            "      \"actionId\": 1,\n" +
            "      \"url\": \"url\",\n" +
            "      \"repeatTimes\": 5,\n" +
            "      \"repeatInterval\": 20,\n" +
            "      \"method\": \"GET\",\n" +
            "      \"params\": null,\n" +
            "      \"headers\": [\n" +
            "        {\n" +
            "          \"name\": \"User-Agent\",\n" +
            "          \"value\": \"\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"name\": \"Accept\",\n" +
            "          \"value\": \"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"cookies\": null,\n" +
            "      \"content\": null,\n" +
            "      \"response\": {\n" +
            "        \"headers\": null,\n" +
            "        \"cookies\": [\n" +
            "          {\n" +
            "            \"name\": \"JSESSIONID\",\n" +
            "            \"variable\": \"cookie1\"\n" +
            "          }\n" +
            "        ],\n" +
            "        \"body_params\": null,\n" +
            "        \"keys\": null\n" +
            "      }\n" +
            "    }";

    public static void main(String[] args) throws IOException {

        ObjectMapper mapper = new ObjectMapper();

        mapper.writerFor(ActionResponse.class);
//        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS,false);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        ArrayList<ActionResponse.NameVariablePair> nameVariablePairs = Lists.newArrayList();
        nameVariablePairs.add(new ActionResponse.NameVariablePair("JSESSIONID", "cookie1"));

        ArrayList<ActionResponse.ResBodyParam> ResBodyParams = Lists.newArrayList();
        ResBodyParams.add(new ActionResponse.ResBodyParam("script_url", "2","script src=\"|\""));

        ArrayList<ActionResponse.ResBodyKey> keys = Lists.newArrayList();
        keys.add(new ActionResponse.ResBodyKey("nextportal.hlifeplus.com", 1));

        ActionResponse res = new ActionResponse(null, nameVariablePairs, ResBodyParams, keys);

        //        String resString = mapper.writeValueAsString(new ActionResponse.ResBodyParam("script_url", "2","script src=\"|\""));

        String resString = mapper.writeValueAsString(res);

//        System.out.println(resString);

        JsonFactory jsonFactory = new JsonFactory();
        JsonGenerator generator = jsonFactory.createGenerator(System.out);

        JsonFactory factory = mapper.getFactory();
        JsonGenerator jsonGenerator = factory.createGenerator(System.out);

        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("response",resString);
        jsonGenerator.writeEndObject();

//        jsonGenerator.enable(SerializationFeature.INDENT_OUTPUT);
        jsonGenerator.flush();
        jsonGenerator.setPrettyPrinter((PrettyPrinter) PrettyPrinter.DEFAULT_ROOT_VALUE_SEPARATOR);



    }
}
