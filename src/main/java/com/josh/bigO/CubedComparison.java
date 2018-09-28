package com.josh.bigO;

import java.util.HashMap;

public class CubedComparison {
    public static void main(String[] args) {
        // find a, b, c, d where a^3 + b^3 == c^3 + d^3
        //N4Impl();

        int n = 1000;
        HashMap<Double, IntPair> cd = new HashMap<>();

        // O (n^2)
        for (int c = 1; c < n; c++) {
            for (int d = 1; d < n; d++) {
                cd.put(Math.pow(c, 3) + Math.pow(d, 3), new IntPair(c, d));
            }
        }

        long start = System.currentTimeMillis();
        long count = 0;

        // O (n^2)
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                double cur = (Math.pow(a, 3) + Math.pow(b, 3));
                if (cd.containsKey(cur)) {
                    IntPair pair = cd.get(cur);
                    count++;
//                    System.out.printf("Found at: %d, %d, %d, %d%n", a, b, pair.a, pair.b);
                }
            }
        }

        System.out.printf("Total time for O (n^2 + n^2): %dms -- ct: %d", System.currentTimeMillis() - start, count);
    }

    private static void N4Impl() {
        int n = 1000;
        long start = System.currentTimeMillis();

        // O (n^4)
        for (int a = 1; a < n; a++) {
            for (int b = 1; b < n; b++) {
                for (int c = 1; c < n; c++) {
                    for (int d = 1; d < n; d++) {
                        if ((Math.pow(a, 3) + Math.pow(b, 3)) == (Math.pow(c, 3) + Math.pow(d, 3))) {
                            //System.out.printf("Found at: %d, %d, %d, %d%n", a, b, c, d);
                        }
                    }
                }
            }
        }

        System.out.printf("Total time for O (n^4): %dms", System.currentTimeMillis() - start);
    }
}
