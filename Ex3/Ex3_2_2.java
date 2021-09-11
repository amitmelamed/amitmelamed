package com.company;

import java.util.ArrayList;

public class Ex3_2_2 {
    public static boolean checkPowerThree(int x){
        if(x<=0)
            return false;
        ArrayList<Integer> powerList=new ArrayList();
        while(x>0){
            int power=0;
            while (Math.pow(3,power+1)<=x){
                power++;
            }
            powerList.add(power);
            x= (int) (x-Math.pow(3,power));
        }
        for(int i=0;i<powerList.size();i++){
            int count=0;
            for(int k=0;k<powerList.size();k++){
                if(powerList.get(i)==powerList.get(k))
                    count++;
            }
            if(count>1) {
                return false;
            }
        }
        printArrayList(powerList);
        return true;
    }
    public static void printArrayList(ArrayList<Integer> arrayList){
        for(int i=0;i<arrayList.size();i++){
            System.out.println(arrayList.get(i));
        }
    }
    public static void main (String [] args){
        System.out.println(checkPowerThree(13));
    }
}
