package com.lang3;

import org.apache.commons.lang3.*;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * org.apache.commons.lang3
 * org.apache.commons.lang3.builder 构造
 * org.apache.commons.lang3.concurrent 并发
 * org.apache.commons.lang3.event
 * org.apache.commons.lang3.exception
 * org.apache.commons.lang3.math
 * org.apache.commons.lang3.mutable
 * org.apache.commons.lang3.reflect
 * org.apache.commons.lang3.text
 * org.apache.commons.lang3.text.translate
 * org.apache.commons.lang3.time 时间
 * org.apache.commons.lang3.tuple 元组
 */
public class LangPackInfo {
    public static void main(String[] args) {

    }

    private void arrayUtil() {

        // ArrayUtils：用于对数组的操作，如添加、查找、删除、子数组、倒序、元素类型转换等
        Integer[] emptyIntegerObjectArray = ArrayUtils.EMPTY_INTEGER_OBJECT_ARRAY;

        //初始化
        Integer[] integers = ArrayUtils.toArray(1, 2, 3);
        Serializable[] serializables = ArrayUtils.toArray(1, 2, "3");

        //null转换为空数组  不为空则返回自己
        Integer[] integers1 = ArrayUtils.nullToEmpty(new Integer[5]);

        //原生和包装类型转换
        Integer[] inArr = new Integer[]{1, 2, 3};
        int[] ints = ArrayUtils.toPrimitive(inArr);
        Integer[] integerArray = ArrayUtils.toObject(ints);

        //变为String数组
        String[] strings = ArrayUtils.toStringArray(inArr);
    }

    private void charUtil() {
        // 把char或者String转为一个Character对象。互转。Character,valueOf()很多时候也能达到这个效果
        char a = CharUtils.toChar('A');

        //得到int值
        int charIntValue = CharUtils.toIntValue('A');

        //判断该字符是否是Ascii码
        boolean isAscii = CharUtils.isAscii('A');
    }

    private void callPathUtil() {
        String fullPath = ClassPathUtils.toFullyQualifiedName(Integer.class, "");
        //java.lang.
        System.out.println(fullPath);
        //fullPath = ClassPathUtils.toFullyQualifiedName(Integer.class.getPackage(), "Integer.value");
        fullPath = ClassPathUtils.toFullyQualifiedName(Integer.class, "Integer.value");
        //java.lang.Integer.value
        System.out.println(fullPath);
    }

    private void callUtil(){
        //int[]
        System.out.println(int[].class.getSimpleName());

        //java.lang
        System.out.println(ClassUtils.getPackageName(String.class));

        //[class java.util.AbstractList, class java.util.AbstractCollection, class java.lang.Object]
        List<Class<?>> allSuperclasses = ClassUtils.getAllSuperclasses(ArrayList.class);
        System.out.println(ArrayUtils.toString(allSuperclasses));

        //[class java.lang.Integer, null]
        List<Class<?>> classes = ClassUtils.convertClassNamesToClasses(Arrays.asList("java.lang.Integer","java.lang.int"));
        System.out.println(classes);

        //isPrimitiveOrWrapper、isPrimitiveWrapper 、primitiveToWrapper、primitivesToWrappers、wrapperToPrimitive判断是基本类型还是包装类型
        //检测是否是基本类型 false
        System.out.println(Object.class.isPrimitive());

        Iterable<Class<?>> hierarchy = ClassUtils.hierarchy(ArrayList.class);
        hierarchy.forEach(System.out::println);
        //输出了类的层级结构（默认是不包含接口的）
        //class java.util.ArrayList
        //class java.util.AbstractList
        //class java.util.AbstractCollection
        //class java.lang.Object
    }

    private void randomUtils(){
        int i = RandomUtils.nextInt();
    }

    private void systemutil(){
        File javaHome = SystemUtils.getJavaHome();
        boolean isOsLinux = SystemUtils.IS_OS_LINUX;
    }
}
