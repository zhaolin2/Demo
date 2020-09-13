package com.javase.encry;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

/**
 * 最常见编码算法 urlencode base64
 * url编码  把中文 日文这种字符转化为ASCII字符
 * base64 A-Z a-z  0-9 + /
 */
public class EncryDemo {
    public static void main(String[] args) throws UnsupportedEncodingException {

        String string = URLEncoder.encode("中国", "UTF-8");
        Base64.getEncoder().encodeToString("test".getBytes());
        Base64.getUrlEncoder().encodeToString("test".getBytes());
    }
}
