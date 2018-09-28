package com.josh;

public class EuclideanAlgorithm {
    public static void main(String[] args) {
        int x = 1112;
        int y = 695;

        int gcd = findGCD(x, y);

        System.out.printf("Largest GCD of %s and %s is %s.%n", x, y, gcd);
    }

    private static int findGCD(int x, int y) {

        while (x % y != 0) {
            y = x % y;
        }

        return y;
    }
}
