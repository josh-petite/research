package com.josh.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class ListIteratorPractice {
    public static void main(String[] args) {

        Random r = new Random();
        List<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < r.nextInt(50); i++) {
            numbers.add(r.nextInt(100));
        }

        System.out.println(numbers);

        killEvenNumbers(numbers);
        killOddNumbers(numbers);

        System.out.println(numbers);
    }

    private static void killOddNumbers(List<Integer> numbers) {
        numbers.removeIf(current -> current % 2 == 1);
    }

    private static void killEvenNumbers(List<Integer> numbers) {
        ListIterator<Integer> li = numbers.listIterator();

        while (li.hasNext()) {
            Integer current = li.next();
            if (current % 2 == 0) {
                li.remove();
            }
        }
    }
}
