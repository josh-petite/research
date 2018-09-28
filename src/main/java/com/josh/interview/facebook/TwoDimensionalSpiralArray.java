package com.josh.interview.facebook;

public class TwoDimensionalSpiralArray {
    public static void main(String[] args) {

        int[][] result = spiral(3);
        print(result);
    }

    static void print(int[][] r) {
        for (int i = 0; i < r.length; i++) {
            for (int j = 0; j < r[i].length; j++) {
                System.out.printf("%d ", r[i][j]);
            }

            System.out.println();
        }
    }

    private static int[][] spiral(int n) {
        int[][] result = new int[n][n];

        int xo = 0, yo = 0, ct = 1;
        int top = 0, right = n - 1, bottom = n - 1, left = 0;

        while (ct <= Math.pow(n, 2)) {
            result[xo][yo] = ct;

            if (xo < right) {
                xo++;
                ct++;
                continue;
            } else if (yo == top) {
                top++;
            }

            if (yo < bottom) {
                yo++;
                ct++;
                continue;
            } else if (xo == right) {
                right--;
            }

            if (xo > left) {
                xo--;
                ct++;
                continue;
            } else if (yo == bottom) {
                bottom--;
            }

            if (yo > top) {
                yo--;
                ct++;
                continue;
            } else if (yo == left) {
                left++;
            }
        }

        return result;
    }
}
