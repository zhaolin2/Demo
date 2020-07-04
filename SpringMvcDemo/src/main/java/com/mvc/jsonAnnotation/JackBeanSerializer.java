package com.mvc.jsonAnnotation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

/**
 * @author zl
 */
public class JackBeanSerializer extends JsonSerializer<JackBean> {

    @Override
    public void serialize(JackBean bean, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeStringField("user-name", bean.getName());
        generator.writeStringField("user-pass",bean.getPass());
        generator.writeEndObject();
    }
}
