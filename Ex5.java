package com.company;
import java.util.Scanner;
import java.awt.*;

public class Ex5 {


    public static void main(String[] args) {

        int choose=1;
        Scanner scanner=new Scanner(System.in);
        while (choose==1){
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
            StdDraw.setScale(-20,20);
            StdDraw.clear();
            StdDraw.setPenRadius(0.005);
            StdDraw.setPenColor(Color.black);
            StdDraw.line(-20,0,20,0);
            StdDraw.line(0,20,0,-20);
            StdDraw.setPenColor(Color.red);
            double y,previusY,previusX;
            previusX=-20;
            previusY=previusX*previusX*a+previusX*b+c;
            for (double i=-20;i<=20;i=i+0.1){
                y=i*i*a+i*b+c;
                StdDraw.point(i,y);
                StdDraw.line(i,y,previusX,previusY);

                previusY=y;
                previusX=i;
            }
            System.out.println("to repeat the proram press 1 to extis press 0 or different number");
            choose=scanner.nextInt();
        }
    }
}
