package com.josh.recursion;

import java.util.Random;

public class RecursiveMultiply {
    public static void main(String[] args) {

        // recursively multiply two positive integers without using * operator
        Random r = new Random();

        int answer = recursivelyMultiply(r.nextInt(20), r.nextInt(20));
//        int answer = recursivelyMultiply(11, 5);
        System.out.println("Ans: " + answer);
    }

    private static int recursivelyMultiply(int left, int right) {
        if (left == 0 || right == 0) {
            return 0;
        }

        System.out.println(String.format("Left: %s, Right: %s", left, right));

        if (right == 1) {
            return left;
        }

        return recursivelyMultiply(left << 1, right >> 1)
                + (right % 2 == 1 ? left : 0);
    }
}
