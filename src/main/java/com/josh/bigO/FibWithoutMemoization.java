package com.josh.bigO;

public class FibWithoutMemoization extends Clockable {
    public static void main(String[] args) {
        // O (2^k) -- where k is size of recursive chain, in this case 50
        Long n = 50L;
        Long answer = run(() -> fib(n));
        System.out.printf("Fib of %d: %d%n", n, answer);
    }

    private static Long fib(Long n) {
        if (n == 0 || n == 1) {
            return 1L;
        }

        return fib(n - 1) + fib(n - 2);
    }
}
