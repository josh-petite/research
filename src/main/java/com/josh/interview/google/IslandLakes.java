package com.josh.interview.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Stack;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class IslandLakes {
    public static void main(String[] args) {
        int[] heights = new int[]{1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2, 1};

        clock(() -> stackSolution(heights));
        clock(() -> doubleCursorSolution(heights));

        System.out.printf("Odd heights: %s%n",
                filter(
                        h -> h % 2 != 0,
                        Arrays.stream(heights).boxed().collect(Collectors.toList())
                )
        );

        System.out.printf("Even heights: %s%n",
                filter(
                        h -> h % 2 == 0,
                        Arrays.stream(heights).boxed().collect(Collectors.toList())
                )
        );
    }

    private static <T> Collection<T> filter(Predicate<T> predicate, Collection<T> items) {
        Collection<T> result = new ArrayList<>();

        for (T item : items) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }

        return result;

        // return items.stream().filter(predicate).collect(Collectors.toList());
    }

    private static void clock(Supplier<Integer> func) {
        long start = System.nanoTime();

        int result = func.get();

        long stop = System.nanoTime();

        System.out.printf("(%sns) -- Total water volume: %s%n", stop - start, result);
    }

    private static Integer stackSolution(int[] heights) {
        int current = 0;
        int waterVolume = 0;

        Stack<Integer> currentLake = new Stack<>();

        while (current < heights.length) {

            while (!currentLake.empty() && heights[current] > heights[currentLake.peek()]) {
                int top = currentLake.pop();

                if (currentLake.empty()) {
                    break;
                }

                int distance = current - currentLake.peek() - 1;
                int boundedHeight = Math.min(heights[current], heights[currentLake.peek()]) - heights[top];

                waterVolume += distance * boundedHeight;
            }

            currentLake.push(current++);
        }

        return waterVolume;
    }

    private static Integer doubleCursorSolution(int[] heights) {
        int left = 0;
        int right = heights.length - 1;
        int leftMax = 0, rightMax = 0;

        int waterVolume = 0;

        while (left < right) {
            if (heights[left] < heights[right]) {

                if (heights[left] >= leftMax) {
                    leftMax = heights[left];
                } else {
                    waterVolume += leftMax - heights[left];
                }

                ++left;

            } else {

                if (heights[right] >= rightMax) {
                    rightMax = heights[right];
                } else {
                    waterVolume += rightMax - heights[right];
                }

                --right;
            }
        }

        return waterVolume;
    }
}
