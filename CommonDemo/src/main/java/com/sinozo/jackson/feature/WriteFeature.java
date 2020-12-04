package com.sinozo.jackson.feature;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.json.JsonWriteFeature;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/17
 */
public class WriteFeature {
    public static void main(String[] args) throws IOException {


        JsonFactory factory = new JsonFactoryBuilder()
                // 在此处开启/关闭特性
                //        是否使用双引号包裹属性名
                .enable(JsonWriteFeature.QUOTE_FIELD_NAMES)
                //WRITE_NAN_AS_STRINGS(true, JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS)：是否将NAN输出为字符串
                //WRITE_NUMBERS_AS_STRINGS(false, JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS)：是否将数字也输出为字符串（有双引号包裹）
                //ESCAPE_NON_ASCII(false, JsonGenerator.Feature.ESCAPE_NON_ASCII)：对于超过7位的ASCII码，是否采用转义输出
                .build();
        // ==========在这完成你的Feature定制==========

        // 输出写到控制台
        JsonGenerator jsonGenerator = factory.createGenerator(new PrintWriter(System.out));

        jsonGenerator.writeStartObject();
        // ... 在此处书写你需要测试的代码
        jsonGenerator.writeEndObject();

        // 说明：只有等到这边flush/close了，你的文件/流里才会有值的哦
        jsonGenerator.flush();
        jsonGenerator.close();
//        QUOTE_FIELD_NAMES(true, JsonGenerator.Feature.QUOTE_FIELD_NAMES)：
    }
}
