package com.jackson;

public enum Test {
    spring(0),test(2);

    private Test(Integer code){
        this.code=code;
    }
    private Integer code;

    private Integer getCode() {
        return code;
    }

    private void setCode(Integer code) {
        this.code = code;
    }
}
