package com.javase.java8;

import lombok.*;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 对象::实例方法名
 * 类::静态方法名
 * 类::实例方法名
 * 类::new （构造器引用）
 * 数组引用。Type::new （new String[]::new）
 */
public class MethodReferenceDemo {

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    private static class Student {

        private String stuName; //学生姓名
        private Integer stuAge; //学生年龄
        private Double stuGrade;//学生成绩

        //单独写一个 只有一个参数的构造函数
        public Student(String stuName) {
            this.stuName = stuName;
        }

    }

    public static void main(String[] args) {
        Student stu = new Student("张三", 18, 85.0);
        //Supplier<String> supp=()->stu.getStuName();  //[原来写法]
        Supplier<String> supp = stu::getStuName;      //[使用方法引用]
        System.out.println(supp.get()); //张三

        //Comparator<Integer> com=(x,y)->Integer.compare(x, y);  //[原来写法]
        Comparator<Integer> com = Integer::compare;               //[使用方法引用]
        System.out.println(com.compare(1, 2)); //-1

        //  BiPredicate<String, String> biPre=(str1,str2)->str1.equals(str2); //[原来写法]
        BiPredicate<String, String> biPre = String::equals;                    //[使用方法引用]
        System.out.println(biPre.test("aaa", "aaa")); //true

        //Supplier<Student> supp=()->new Student(); //[原来写法]
        //Function<String, Student> supp = (name) -> new Student(name); //[原来写法]

        Supplier<Student> supp1 = Student::new; //无参构造
        Function<String, Student> funOneParam = Student::new; //有参构造
        //我们发现 如果参数实在太多（超过3个），就不用使用构造函数引用了 (除非自定义一个函数式接口)
        //BiFunction<String,Integer,Function<Double,Student>> suppAllParam = Student::new; //全参构造

        System.out.println(supp1.get()); //Student(stuName=null, stuAge=null, stuGrade=null)
        System.out.println(funOneParam.apply("fsx")); //Student(stuName=fsx, stuAge=null, stuGrade=null)


        //Function<Integer, String[]> supp = x -> new String[x];

        Function<Integer, String[]> supp2 = String[]::new;
        String[] array = supp2.apply(10);
        System.out.println(array.length); //输出 10
    }

}
