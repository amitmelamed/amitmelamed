package com.company;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex2 {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter 2 numbers to multiply");
        int a=scanner.nextInt();
        int b=scanner.nextInt();
        ArrayList<Integer> arrayList1=new ArrayList();
        ArrayList<Integer> arrayList2=new ArrayList();
        int size=0;
        for(int i=1;i<=a;i=i*2){
            arrayList1.add(i);
            arrayList2.add(i*b);
            size++;
        }
        int count=0;
        int sum=0;
        for(int i=size-1;i>=0;i--){
            if((count+arrayList1.get(i))<=a){
                count=count+arrayList1.get(i);
                sum=sum+arrayList2.get(i);
            }
        }
        System.out.println(sum);

    }

}
