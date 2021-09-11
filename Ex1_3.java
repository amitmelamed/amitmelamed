package com.company;
import java.util.Scanner;

public class Ex1_3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter number and then enter gap");
        int num1=scanner.nextInt();
        int gap=scanner.nextInt();

        for(int i=1;i<=num1;i++){
            int twin=i+gap;
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
                System.out.println("twin gap found: "+i+" "+twin);
            }

        }
    }
}
