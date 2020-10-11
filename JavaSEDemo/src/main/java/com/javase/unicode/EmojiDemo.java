package com.javase.unicode;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

/**
 * https://developer.ibm.com/zh/articles/j-lo-chinesecoding/ 中文编码问题
 * http需要编码的地方 URL、Cookie、Parameter
 * 表情对应的demo unicode
 * java的char类型对应的是16bit 相当于两个字节 所以可以存储0-65535 的 Unicode字符
 *
 * utf-8 不定长
 * utf-16 定长 每个16bit
 *
 * t byte[] 1
 * 从 byte[] 3
 */
public class EmojiDemo {
    public static void main(String[] args) {
        // 用户昵称为：🐳🐳🐠，正常结果应该为：🐳***🐠
//        String context = "\uD83D\uDC33\uD83D\uDC33\uD83D\uDC20";
//        int realNameLength = realStringLength(context);
//        String namePrefix = subString(context, 1, 0);
//        String nameSuffix = subString(context, realNameLength - 1, 1);
//        context = String.format("%s%s%s", namePrefix, "***", nameSuffix);
//        System.out.println(context);

    }

    /**
     * 包含emoji表情的subString方法
     *
     * @param str 原有的str
     * @param len str长度
     * @param type type = 0 代表prefix，其他代表suffix
     */
    private static String subString(String str, int len, int type) {
        if (len < 0) {
            return str;
        }

        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (count == len) {
                // type = 0 代表prefix，其他代表suffix
                if (type == 0) {
                    return str.substring(0, i);
                }
                return str.substring(i);
            }

            char c = str.charAt(i);
            if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                i++;
            }
            count++;
        }

        return str;
    }

    /**
     * 包含emoji表情的字符串实际长度
     *
     * @param str 原有str
     * @return str实际长度
     */
    private static int realStringLength(String str) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isHighSurrogate(c) || Character.isLowSurrogate(c)) {
                i++;
            }
            count++;
        }


        return count;
    }






}
