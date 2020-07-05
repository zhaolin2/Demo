package com.mvc.customize;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Description: 自定义转换器  application/toString -> 对象的ToString返回
 * @Author: 赵
 * @date: 2020/7/5
 *
 * 源码可以查看
 * {@link org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor#handleReturnValue(java.lang.Object, org.springframework.core.MethodParameter, org.springframework.web.method.support.ModelAndViewContainer, org.springframework.web.context.request.NativeWebRequest)}
 */
public class MyHttpMessageConverter extends AbstractHttpMessageConverter<Object> {

    public MyHttpMessageConverter(){
        super(new MediaType("application","toString", StandardCharsets.UTF_8));
    }
    @Override
    protected boolean supports(Class aClass) {
        return true;
    }

    @Override
    protected Object readInternal(Class aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        return  StreamUtils.copyToString(httpInputMessage.getBody(), StandardCharsets.UTF_8);
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        String result = o.toString();
        httpOutputMessage.getBody().write(result.getBytes());
    }
}
