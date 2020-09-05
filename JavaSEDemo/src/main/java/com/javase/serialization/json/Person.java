package com.javase.serialization.json;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/8/7
 */
@Accessors(chain = true)
@Setter
@Getter
public class Person {
    String name;

    Integer age;
}
