package com.jackson.feature;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonFactoryBuilder;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.json.JsonReadFeature;

import java.io.IOException;

/**
 * 为了兼容才出现的这些特征值，建议别开启
 */
public class ReadFeature {
    public static void main(String[] args) throws IOException {
//        ALLOW_JAVA_COMMENTS(false, JsonParser.Feature.ALLOW_COMMENTS)：不解释
//        ALLOW_YAML_COMMENTS(false, JsonParser.Feature.ALLOW_YAML_COMMENTS)：不解释
//        ALLOW_SINGLE_QUOTES(false, JsonParser.Feature.ALLOW_SINGLE_QUOTES)：是否允许单引号’包裹着也行，默认是不允许的（因为这不是JSON规范）
//        ALLOW_UNQUOTED_FIELD_NAMES(false, JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)：是否允许属性名不需要双引号包裹也行。默认是不允许的（也就是说必须有双引号包裹才行）
//        ALLOW_UNESCAPED_CONTROL_CHARS(false, JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS)：是否允许出现未转义的制表符和换行符等（若出现了就会抛出异常）
//        ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER(false, JsonParser.Feature.ALLOW_BACKSLASH_ESCAPING_ANY_CHARACTER)：是否支持反斜杠的引用机制
//        ALLOW_LEADING_ZEROS_FOR_NUMBERS(false, JsonParser.Feature.ALLOW_NUMERIC_LEADING_ZEROS)：是否允许0开头的数字，比如000001这种
//        ALLOW_NON_NUMERIC_NUMBERS(false, JsonParser.Feature.ALLOW_NON_NUMERIC_NUMBERS)：是否接收NaN作为一个number
//        ALLOW_MISSING_VALUES(false, JsonParser.Feature.ALLOW_MISSING_VALUES)：允许支持JSON数组中的“缺失”值。确实值的意思是：数组的两个,号之间木有值（注意：空格也不算有值，除非是空串""）
//        ALLOW_TRAILING_COMMA(false, JsonParser.Feature.ALLOW_TRAILING_COMMA) ：是否允许最后一个多余的逗号
        JsonFactory factory = new JsonFactoryBuilder()
                //
                .enable(JsonReadFeature.ALLOW_LEADING_ZEROS_FOR_NUMBERS)
                .build();

        // 输出写到控制台
        String jsonStr = "{\"money\" : 00001}";
        JsonParser jsonParser = factory.createParser(jsonStr);
        while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
            String fieldname = jsonParser.getCurrentName();
            if ("money".equals(fieldname)) {
                System.out.println(jsonParser.nextIntValue(0));
            }
        }
        jsonParser.close();
    }
}
