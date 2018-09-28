package com.josh.bigO;

public class TwoCollections {
    public static void main(String[] args) {

        int a = 10;
        int b = 5;

        // O (A * B)
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                System.out.printf("%d,%d  ", i, j);
            }

            System.out.println();
        }
    }
}
