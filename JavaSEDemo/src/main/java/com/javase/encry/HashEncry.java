package com.javase.encry;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * hash也叫摘要算法(digest)
 * hash算法的核心是把一组任意的输入得到一个固定长度的输出
 *   相同的输入要得到相同的输出
 *    不同的输入大概率得到不同的输出
 *
 *   hash碰撞 不同的输入得到相同的输出
 *
 *  常见的hash算法
 *  MD5 16 byte
 *  SHA-1 20 byte
 *  RipeMD-160 20 byte
 *  SHA-256 32 byte
 *  SHA-512 64byte
 *
 *  常见的md5加密其实常见的是有对照表的  也叫做彩虹表
 *
 *  为了避免这样的情况来加上随机数(盐)来防御
 */
public class HashEncry {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update("test".getBytes());
         md5.digest();

    }
}
