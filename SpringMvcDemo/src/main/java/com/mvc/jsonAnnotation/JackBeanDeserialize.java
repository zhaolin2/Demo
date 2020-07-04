package com.mvc.jsonAnnotation;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

/**
 * @author zl
 */
public class JackBeanDeserialize extends JsonDeserializer<JackBean> {

    @Override
    public JackBean deserialize(JsonParser parser, DeserializationContext context)
            throws IOException, JsonProcessingException {
        JsonNode node = parser.getCodec().readTree(parser);
        String userName = node.get("user-name").asText();
        String pass = node.get("user-pass").asText();
        JackBean bean = new JackBean();
        bean.setName(userName);
        bean.setPass(pass);
        return bean;
    }
}