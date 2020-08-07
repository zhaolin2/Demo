package com.javase.designPattern.singlenton;

import com.javase.designPattern.singlenton.lazy.DoubleCheckSingleton;
import java.io.*;

/**
 * @Description:单例的测试类
 * @Author: zl
 * @date: 2020/8/5
 */
public class SingleClientDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Write Obj to file
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:\\tmp\\temp.txt"));
        oos.writeObject(DoubleCheckSingleton.getSingleton());
        //Read Obj from file
        File file = new File("D:\\tmp\\temp.txt");
        ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(file));
        DoubleCheckSingleton newInstance = (DoubleCheckSingleton) ois.readObject();
        //判断是否是同一个对象
        //false 因为会调用反射调用无参数的的构造参数来创建一个新的对象
        //true 重写readResolve 指定返回的对象
        System.out.println(newInstance == DoubleCheckSingleton.getSingleton());
    }

}
