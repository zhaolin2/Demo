package com.mvc.jsonAnnotation;

import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author zl
 */
@JsonSerialize(using = JackBeanSerializer.class)
@JsonDeserialize(using = JackBeanDeserialize.class)
public class JackBean {

    public interface NameView {};
    public interface AllView extends NameView {};

    @JsonView(NameView.class)
    String name;

    @JsonView(AllView.class)
    String pass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "JackBean{" +
                "name='" + name + '\'' +
                ", pass='" + pass + '\'' +
                '}';
    }
}
