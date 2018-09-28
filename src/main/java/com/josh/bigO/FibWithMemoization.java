package com.josh.bigO;

import java.util.Arrays;

public class FibWithMemoization extends Clockable {
    public static void main(String[] args) {
        // O (k) -- where k is size of recursive chain, in this case 50
        int n = 50;
        Long[] memo = new Long[50];
        Arrays.fill(memo, 0L);

        Long answer = run(() -> fib(n, memo));
        System.out.printf("Fib of %d: %d%n", n, answer);
    }

    private static Long fib(int n, Long[] memo) {
        if (n == 0 || n == 1) {
            return 1L;
        }

        if (memo[n-1] != 0) {
            return memo[n-1];
        }

        memo[n-1] = fib(n - 1, memo) + fib(n - 2, memo);

        return memo[n-1];
    }
}
