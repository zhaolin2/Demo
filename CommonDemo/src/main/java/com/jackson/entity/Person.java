package com.jackson.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/8/7
 */
@Accessors(chain = true)
@Setter
@Getter
public class Person implements Serializable {
    String name;

    Integer age;
}
