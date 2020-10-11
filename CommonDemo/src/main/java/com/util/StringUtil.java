package com.util;

import java.net.InetSocketAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/11
 */
public class StringUtil {

    private StringUtil(){

    }

    private static Pattern chinesePattern = Pattern.compile("[\u4e00-\u9fa5]");

    //获取字符串的真正长度 包含unicode 编码65535之后的
    public static Integer getLength(String string){
        return (int) string.codePoints().count();
    }


    //判断是否包含中文
    public static boolean inContainChines(String str){

        Matcher matcher = chinesePattern.matcher(str);

        return matcher.find();
    }
}
