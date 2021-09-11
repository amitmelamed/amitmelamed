package com.company;
import java.util.Scanner;

public class Ex1_2 {
    public static void main(String[] args) {
        System.out.println("enter number to print all prime twins until this number");
        Scanner scanner=new Scanner(System.in);
        int num1=scanner.nextInt();
        for(int i=1;i<=num1;i++){
            int twin=i+2;
            boolean flag=true;
            boolean twinFlag=true;

            for(int k=2;k<i;k++){
                if(i%k==0){
                    flag=false;
                }
            }
            for(int k=2;k<twin;k++){
                if(twin%k==0){
                    twinFlag=false;
                }
            }
            if(flag&&twinFlag){
                System.out.println("twin found: "+i+" "+twin);
            }

        }


    }
}