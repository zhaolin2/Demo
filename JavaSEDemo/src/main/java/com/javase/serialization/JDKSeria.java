package com.javase.serialization;

import com.alibaba.fastjson.util.IOUtils;

import java.io.*;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/10/2
 */
public class JDKSeria {

    public static void main(String[] args) throws IOException {
        Person person = new Person().setAge(13);

        //Write Obj to File
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(person);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            assert oos != null;
            oos.close();
        }

        //Read Obj from File
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            Person seriaPerson = (Person) ois.readObject();
            System.out.println(seriaPerson);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            assert ois != null;
            ois.close();
        }

        int a= 10_00;

    }
}
