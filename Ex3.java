package com.company;
import java.util.Scanner;
public class Ex3 {

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter a,b,c parameters");
        double a=scanner.nextDouble();
        double b=scanner.nextDouble();
        double c=scanner.nextDouble();
        double check=b*b-4*a*c;
        if(a==0){
            System.out.println("this is not a parabola");
        }
        else if(check<0){
            System.out.println("the parabola does not intersect the x-axis");
        }
        else if(check==0){
            double sq=Math.sqrt((b*b-4*a*c));
            double x1=(-b+sq)/(2*a);
            System.out.println("X1=X2 "+x1);
        }
        else {
            double sq=Math.sqrt((b*b-4*a*c));
            double x1=(-b+sq)/(2*a);
            double x2=(-b-sq)/(2*a);
            System.out.println("X1= "+x1);
            System.out.println("X2= "+x2);
        }
    }

}
