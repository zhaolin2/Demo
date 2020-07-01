package com.javase.thread;

import java.util.Arrays;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int range = scanner.nextInt();

        int[] a=new int[num];

        boolean flag=false;
        int index=0;
        for (int i = 0; i < num; i++) {
            int order_id = scanner.nextInt();
            int in_time = scanner.nextInt();
            int out_time = scanner.nextInt();

            if(in_time<=range && out_time>=range){
                a[index++]=order_id;
                flag=true;
            }
        }

        if(!flag){
            System.out.println("null");
        }

        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) {
            if (a[i] != 0) {
                System.out.println(a[i]);
            }
        }
    }
}
