package com.javaee.rpc.serialize;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/11/29
 */
@Setter
@Getter
@Builder
public class SerEntity implements Serializable {
    String name;
    String id;
    String test;
}
