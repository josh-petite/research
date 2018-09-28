package com.josh.bigO;

public class OrderedPairs {
    public static void main(String[] args) {
        int n = 10;

        // O (n^2)
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                System.out.printf("%d,%d  ", i, j);
            }

            System.out.println();
        }
    }
}
