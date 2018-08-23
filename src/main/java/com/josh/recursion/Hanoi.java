package com.josh.recursion;

import java.util.Stack;

public class Hanoi {

    /*
    * this is broken
    * */

    private static int n = 6;

    public static void main(String[] args) {

        Stack<Integer> source = new Stack<>();
        for (int i = n; i >= 1; i--) {
            source.push(i);
        }

        Stack<Integer> dest = new Stack<>();

        solveTowersOfHanoi(n, source, dest, new Stack<>());
    }

    private static void solveTowersOfHanoi(int disc, Stack<Integer> source, Stack<Integer> dest, Stack<Integer> spare) {
//        if (isDone(dest)) {
//            return;
//        }

        System.out.println(String.format("D: %s, So: %s, De: %s, Sp: %s", disc, source, dest, spare));

        if (disc == 0) {
            dest.push(source.pop());
        } else {
            solveTowersOfHanoi(disc - 1, source, spare, dest);
            dest.push(source.pop());
            solveTowersOfHanoi(disc - 1, spare, dest, source);
        }
    }

    private static boolean isDone(Stack<Integer> tower) {
        if (tower.size() < n) {
            return false;
        }

        Stack<Integer> copyOfTower = (Stack<Integer>) tower.clone();

        for (int i = 1; i <= n; i++) {
            if (copyOfTower.pop() != i) {
                return false;
            }
        }

        return true;
    }
}
