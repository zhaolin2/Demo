package com.javase.type;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * {@link java.lang.reflect.Type}
 * @Description: 泛型demo
 * @Author: zl
 * @date: 2020/7/18
 * type作为整个java类型中类型的最高抽象 主要包括下边几个实现
 *
 * {@link java.lang.reflect.GenericArrayType} 数组类型 T[]
 * {@link ParameterizedType} 参数化类型  泛型List Map等
 * {@link WildcardType}  {@code ?}, {@code ? extends Number}, or {@code ? super Integer}.
 *              基本就两个方法 来获取上下边界
 * {@link TypeVariable} 类型变量
 *
 * {@link Class} 不只是常用的类 包括枚举 数组 注解等
 */
public class GenericDefinitionDemo {

    /**
     *
     * @param string
     * @param alibaba
     * @param <String>  定义了一个泛型叫做String  并不是java.lang.string
     * @param <T> 泛型T
     * @param <Alibaba> 泛型Alibaba
     * @return
     */
    static <String, T, Alibaba> String get(String string, Alibaba alibaba) {
        return string;
    }

    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException {
        Integer first = 222;
        Long second = 333L;
        //
        Integer result = get(first, second);

//        System.out.println(result);
        GenericDefinitionDemo definitionDemo = new GenericDefinitionDemo();
        definitionDemo.paramTypeTest(new ArrayList<String>());
    }

    private void paramTypeTest(List<String> listParam) throws NoSuchFieldException, NoSuchMethodException {
        /**
         * 第一种好像是利用的匿名内部类来实现的
         * class com.javase.type.GenericDefinitionDemo$1 list的class变为这个
         * 然后获取superclass   java.util.ArrayList<java.lang.String> 可以获取到完整的类型
         */
        List<String> list=new ArrayList<String>(){};
        Type clazz = list.getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType)clazz;
        System.out.println( pt.getActualTypeArguments()[0].toString());

        Method paramTypeTest = GenericDefinitionDemo.class.getDeclaredMethod("paramTypeTest",List.class);
        Type[] types = paramTypeTest.getGenericParameterTypes();
        for (Type type : types){
            if (type instanceof ParameterizedType){
                //获取泛型的实际类型  Map类型的话 可能会有两个泛型
                // 多层的话 List<Map<String,String>> 返回最外层 把Map<String,String> 返回
                Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
                System.out.println(actualTypeArguments[0]);

                //获取声明泛型的类或者接口
                Type rawType = ((ParameterizedType) type).getRawType();
                System.out.println(rawType);

                //获取到泛型的拥有者
                Type ownerType = ((ParameterizedType) type).getOwnerType();
                System.out.println(ownerType);
            }
        }

    }

    private <T extends Number> void genericArrayTypeTest(String[] ts) throws NoSuchMethodException {

        Method genericArrayTypeMetod = GenericDefinitionDemo.class.getDeclaredMethod("genericArrayTypeTest", String[].class);
        Type[] genericParameterTypes = genericArrayTypeMetod.getGenericParameterTypes();
        for (Type generArrayType : genericParameterTypes){
            if (generArrayType instanceof GenericArrayType){

                /**
                 * 会获取脱去[] 之后的类型
                 */
                Type genericComponentType = ((GenericArrayType) generArrayType).getGenericComponentType();
                System.out.println(genericComponentType);
            }
        };
    }

    private  <T> void typeVar(T[] t) throws NoSuchMethodException {
        Method genericArrayTypeMetod = GenericDefinitionDemo.class.getDeclaredMethod("typeVar");
        Type[] genericParameterTypes = genericArrayTypeMetod.getGenericParameterTypes();
        for (Type declaer : genericParameterTypes){
            /**
             * 声明类型中的最高接口 定义了哪些地方可以来声明泛型
             * {@link Class}
             * {@link Method}
             * {@link Constructor}
             */
            if (declaer instanceof GenericDeclaration){
                declaer.getTypeName();
            }
        };
    }

}
