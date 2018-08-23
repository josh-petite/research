package com.josh;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Given a set of objects, return a set of all its subsets (all possible permutations).
// For example, give the input set: {a,b,c}
// the return value should be:
// {{}, {a}, {b}, {c}, {a,b}, {a,c}, {b,c}, {a,b,c}}
public class Main {
    public static void main(String[] args) {

        Set<Object> input = new HashSet<>();
        input.add("a");
        input.add("b");
        input.add("c");
        input.add("d");

//        Set<Set<Object>> results = powerSet(input);
//
//        results.forEach(System.out::println);

//        int r = factorial(4);

//        count7(717);

//        int x = count8(8088);

//        countX("xhixhix");

//        printBinary(3);

//        int perms = diceRoll(3, new ArrayList<>());
//        System.out.println("Permutations: " + perms);

        diceSum(4, new ArrayList<>(), 0, 20);
        System.out.println("count: " + count);
    }

    private static int count = 0;

    private static void diceSum(int numDice, ArrayList<Integer> diceUsed, int sumSoFar, int desiredSum) {
        final int diceSides = 6;
        count++;

        if (numDice == 0) {
            System.out.println(diceUsed);
        }

        for (int i = 1; i <= diceSides; i++) {
            if (sumSoFar + i + numDice - 1 <= desiredSum &&
                    sumSoFar + i + diceSides * (numDice - 1) >= desiredSum) {

                diceUsed.add(i);
                diceSum(numDice - 1, diceUsed, sumSoFar + i, desiredSum);
                diceUsed.remove(diceUsed.size() - 1);
            }
        }
    }

    private static int diceRoll(int numDice, ArrayList<Integer> dice) {
        if (numDice == 0) {
            System.out.println(dice);
            return dice.size();
        }

        int total = 0;

        for (int i = 1; i < 7; i++) {
            dice.add(i);
            total += diceRoll(numDice - 1, dice);
            dice.remove(dice.size() - 1);
        }

        return total;
    }

    private static void printBinary(int digits) {
        printBinaryHelper(digits, "");
    }

    private static void printBinaryHelper(int digits, String prefix) {
        System.out.println(String.format("D: %s, P: %s", digits, prefix));

        if (digits == 0) {
            System.out.println(prefix);
            return;
        }

        printBinaryHelper(digits - 1, prefix + "0");
        printBinaryHelper(digits - 1, prefix + "1");
    }

    public static int countX(String str) {
        if (str.length() == 1) {
            return 0;
        }

        return countX(str.substring(1)) + str.charAt(0) == 'x' ? 1 : 0;
    }


    public static int count8(int n) {
        if (n == 8) {
            return 1;
        }

        if (n < 8) {
            return 0;
        }

        int extra = n / 10 == n % 10 ? 1 : 0;

        return count8(n / 10) + count8(n % 10) + extra;
    }

    public static <T> Set<Set<T>> powerSet(Set<T> originalSet) {
        Set<Set<T>> sets = new HashSet<>();

        if (originalSet.isEmpty()) {
            sets.add(new HashSet<>());
            return sets;
        }

        List<T> list = new ArrayList<>(originalSet);
        T head = list.get(0);
        Set<T> rest = new HashSet<>(list.subList(1, list.size()));
        Set<Set<T>> baseSets = powerSet(rest);

        for (Set<T> baseSet : baseSets) {
            Set<T> newSet = new HashSet<>();
            newSet.add(head);
            newSet.addAll(baseSet);

            sets.add(newSet);
            sets.add(baseSet);
        }

        return sets;
    }

    public static int factorial(int n) {
        if (n < 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }

    public static int count7(int n) {
        if (n < 7 || (n > 7 && n < 10)) {
            return 0;
        }

        if (n == 7) {
            return 1;
        }

        return count7(n / 10) + count7(n % 10);
    }

}
