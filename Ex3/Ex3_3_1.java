package com.company;

public class Ex3_3_1 {
    public static int mod(int m, int n) {
        if (n < 0)
            return mod(m, -n);
        if (m < 0)
            return -mod(-m, n);
        if (m >= n)
            return mod(m - n, n);
        return m;
    }
    public static int[] sortModArray(int[] a, int n) {
        int temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < a.length - 1; i++) {
                if (mod(a[i], n) > mod(a[i + 1], n)) {
                    sorted = false;
                    temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
        return a;
    }
    public static int searchModArray(int[] a, int n,int num){
        int low=0;
        int reminderNum=mod(num,n);
        int high=a.length-1;
        while (high>=low){
            int middle = (low + high) / 2;
            if(a[middle]==num){
                return middle;
            }
            if(mod(a[middle],n)<=reminderNum){
                low=middle+1;
            }
            if(mod(a[middle],n)>reminderNum){
                high=middle-1;
            }
        }
        return -1;
    }
}
