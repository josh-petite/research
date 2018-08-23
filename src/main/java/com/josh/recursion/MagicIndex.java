package com.josh.recursion;

import java.util.*;

public class MagicIndex {
    public static void main(String[] args) {

        long s0 = System.currentTimeMillis();
        Set<Integer> set = generateArray(200000000);
        System.out.println(String.format("Gen Time: %sms", System.currentTimeMillis() - s0));

        long s = System.currentTimeMillis();
        boolean magicIndexExists = linearSearch(set);
//        System.out.println(set);
//        System.out.println("Set size: " + set.size());
        System.out.println("Magic index exists: " + magicIndexExists);
        System.out.println(String.format("Linear Time: %sms", System.currentTimeMillis() - s));

        long s2 = System.currentTimeMillis();
        int index = binarySearch(set.toArray(new Integer[0]), 0, set.size() - 1);
        System.out.println("Index: " + index);
        System.out.println(String.format("BS Time: %sms", System.currentTimeMillis() - s2));
    }

    private static boolean linearSearch(Set<Integer> set) {
        List<Integer> array = new ArrayList<>(set);

        for (int i = 0; i < array.size(); i++) {
            if (array.get(i) == i) {
                return true;
            }
        }

        return false;
    }

    private static Set<Integer> generateArray(int size) {
        Set<Integer> array = new TreeSet<>();
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            array.add(r.nextInt(size));
        }

        return array;
    }

    public static int binarySearch(Integer[] A, int start, int end) {
//        System.out.println();
//        System.out.println("s:" + start + " e:" + end);

        if (start <= end) {
            int mid = (start + end) / 2;
            if (mid == A[mid]) // check for magic index.
                return mid;
            if (mid > A[mid]) { // If mid>A[mid] means fixed point might be on
                // the right half of the array
                return binarySearch(A, mid + 1, end);
            } else {// If mid<A[mid] means fixed point might be on
                // the left half of the array
                return binarySearch(A, start, mid - 1);
            }
        }

        return -1;
    }
}
