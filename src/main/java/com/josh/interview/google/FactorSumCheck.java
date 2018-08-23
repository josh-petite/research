package com.josh.interview.google;

import java.util.HashSet;
import java.util.Set;

public class FactorSumCheck {
    public static void main(String[] args) {

        int input = 12;

        Set<Integer> summations = populateDs(input);

        System.out.println("Has factors equaling 4? " + summations.contains(4));
        System.out.println("Has factors equaling 5? " + summations.contains(5));
        System.out.println("Has factors equaling 6? " + summations.contains(6));
        System.out.println("Has factors equaling 7? " + summations.contains(7));
        System.out.println("Has factors equaling 70? " + summations.contains(70));
    }

    private static Set<Integer> populateDs(int input) {

        Set<Integer> factors = new HashSet<>();
        factors.add(1);
        factors.add(input);

        Set<Integer> summations = new HashSet<>();
        summations.add(1 + input);

        for (int i = input / 2; i > 0; i--) {
            if (input % i == 0) {
                int finalI = i;
                factors.forEach(f -> summations.add(f + finalI));
                factors.add(i);
            }
        }

        System.out.println(factors);

        return summations;
    }
}
