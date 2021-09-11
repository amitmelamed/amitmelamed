package com.company;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static int [][][] random3DMath(int x,int y){
        int [][][] frame=new int[3][x][y];
        Random random=new Random(10);
        for(int c=0;c<3;c++){
            for(int h=0;h<x;h++){
                for(int l=0;l<y;l++){
                    frame[c][h][l]= random.nextInt(2);
                }
            }
        }
        return frame;
    }
    public static void printMat(int [][] mat)
    {
        for(int h=0;h< mat.length;h++){
            for(int l=0;l<mat[h].length;l++){
                System.out.print(mat[h][l]+" ");
            }
            System.out.println();
        }
        System.out.println("*************");
    }

    public static int [][] generateRandom2dMat(int x,int y){
        int [][] mat=new int[x][y];
        Random random=new Random();
        for(int h=0;h<x;h++){
            for(int l=0;l<y;l++){
                mat[h][l]=random.nextInt(255);
            }
        }
        return mat;
    }

    public static void main(String[] args) {
	// write your code here
        FrameContainer frameContainer=new FrameContainer("C:\\Users\\97252\\Desktop\\לימודים\\מבוא לחישוב\\Matala_4\\src\\com\\company\\textContainer.txt",false);
        frameContainer.rotateAll();
        MyImageIO.writeImageToFile(frameContainer.get(0), "frame0");

        ArrayList <Integer> arrayList=new ArrayList<>();
        arrayList.add(5);
        arrayList.add(8);
        System.out.println(arrayList);

    }
}
