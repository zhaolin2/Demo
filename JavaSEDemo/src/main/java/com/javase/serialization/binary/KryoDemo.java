package com.javase.serialization.binary;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.javase.serialization.Person;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @Description:
 * @Author: zl
 * @date: 2020/9/5
 */
public class KryoDemo {
    public static void main(String[] args) throws FileNotFoundException {
        Kryo kryo = new Kryo();
        kryo.register(Person.class);

        Person person = new Person().setAge(14).setName("4534");

        Output output = new Output(new FileOutputStream("file.bin"));
        kryo.writeObject(output, person);
        output.close();

        Input input = new Input(new FileInputStream("file.bin"));
        Person readPerson = kryo.readObject(input, Person.class);
        input.close();
    }
}
