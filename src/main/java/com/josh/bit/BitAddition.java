package com.josh.bit;

import java.util.Random;

public class BitAddition {

    public static void main(String[] args) {

        Random r = new Random();
        int n = r.nextInt(100);

        bitAddOne(n);
    }

    private static void bitAddOne(int n) {
        System.out.println("Input: " + n);
        int answer;

        if (n % 2 == 0) {
            answer = n | 1;
        } else {
            answer = n & -n;

//            while (n > 0) {
//                if (n) {
//
//                }
//
//                n >>= 1;
//            }
        }

        System.out.println("Answer: " + answer);
    }
}
