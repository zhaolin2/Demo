package com.jackson;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description:action的response
 * @Author: zl
 * @date: 2020/8/16
 */
@Data
public class ActionResponse {

    List<NameVariablePair> headers;
    List<NameVariablePair> cookies;
    List<ResBodyParam> body_params;
    List<ResBodyKey> keys;

    public ActionResponse(List<NameVariablePair> headers,List<NameVariablePair> cookies,
            List<ResBodyParam> body_params,
            List<ResBodyKey> keys){
        this.headers=headers;
        this.cookies=cookies;
        this.body_params=body_params;
        this.keys=keys;
    }

    @Data
    @AllArgsConstructor
    public static class ResBodyParam implements Serializable {
         String variable;
         String value_type;
         String value_key;
    }

    @Data
    @AllArgsConstructor
    public static class ResBodyKey{
         String key;
         Integer step;
    }

    @Data
    public static class NameVariablePair {
        String name;
        String variable;

        public NameVariablePair(String name, String variable) {
            this.name=name;
            this.variable=variable;
        }
    }
}
