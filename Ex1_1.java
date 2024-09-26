package com.company;

import java.util.Scanner;

public class Ex1_1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter number to check if he is prime");
        int num=scanner.nextInt();
        boolean flag=true;
        for(int i=2;i<num;i++){
            if(num%i==0){
                flag=false;
            }
        }
        System.out.println(flag);
    }
}
