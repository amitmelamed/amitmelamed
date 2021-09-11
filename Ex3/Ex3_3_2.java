package com.company;

public class Ex3_3_2 {
    public static int phi(int n) {
        if (n < 1) {
            return 0;
        }
        int count = 0;
        if (n == 1) {
            return 1;
        }
        for (int i = 1; i < n; i++) {
            if (gcd(i, n) == 1) {
                count++;
            }
        }
        return count;
    }
    public static int gcd(int num1, int num2) {
        if (num2 != 0) {
            return gcd(num2, mod(num1, num2));
        } else {
            return num1;
        }
    }
    public static int mod(int m, int n) {
        if (n < 0)
            return mod(m, -n);
        if (m < 0)
            return -mod(-m, n);
        if (m >= n)
            return mod(m - n, n);
        return m;
    }
    public static void main(String[] args){
        System.out.println(phi(7));
    }
}
