package com.mvc.databiner;

import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

/**
 * @author zl
 */

public class Data {
    String test;
    Date date;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
