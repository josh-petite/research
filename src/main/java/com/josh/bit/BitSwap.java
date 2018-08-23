package com.josh.bit;

public class BitSwap {
    public static void main(String[] args) {
        int x = 9;
        int y = 17;

        System.out.println("X: " + x);
        System.out.println("Y: " + y);

        x = y ^ x; // 10001 ^ 01001 = 11000
        y = x ^ y; // 11000 ^ 10001 = 01001
        x = x ^ y; // 11000 ^ 01001 = 10001

        System.out.println("X: " + x);
        System.out.println("Y: " + y);
    }
}
