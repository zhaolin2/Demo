package com.javase.thread.multi_thread;

public class Father {

    public Father(){

    }
    public Father(int x){
        System.out.println("a"+x);
    }

    public static void main(String[] args) {
        son son = new son(2);
    }
}

class son extends Father {
    public son(int x){
        System.out.println("b"+x);
    }
}
