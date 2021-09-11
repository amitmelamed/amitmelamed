package com.company;

import java.util.Random;
import java.util.Scanner;

public class Ex3_1 {
    public static void guessNumber(int N) {
        Scanner scanner=new Scanner(System.in);
        Random rnd=new Random();
        if(N<0){
            System.out.println("choose natural N wrong input");
            return;
        }

        int upperLimit=N;
        int lowerLimit=0;
        int count=0;
        int choose=0;
        int number;
        //Random random=new Random();
        while(choose!=1)
        {
            count++;
            number=(upperLimit+lowerLimit)/2;
            // number=random.nextInt(upperLimit - lowerLimit+1 ) + lowerLimit;
            System.out.println("is the number equal to: "+number);
            System.out.println("choose 1 if "+number+" is equal to you guees");
            System.out.println("choose 2 if you guess is lower then "+number);
            System.out.println("choose 3 if you guess is bigger then "+number);
            choose=scanner.nextInt();
            if(lowerLimit==upperLimit){
                System.out.println("the number is: "+upperLimit+" number of plays: "+count);
                return;
            }
            if(choose==1){
                System.out.println("win plays: "+count);

            }else if(choose==2){
                upperLimit=number-1;

            }
            else if (choose==3){
                lowerLimit=number+1;
            }else {
                System.out.println("choose correct input");
            }
        }
    }
    public static void main(String[] args) {
        guessNumber(500);
    }

}
