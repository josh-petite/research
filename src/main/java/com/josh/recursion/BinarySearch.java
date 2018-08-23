package com.josh.recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] sortedData = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};

        int index = search(sortedData, 3);
        System.out.println("Index: " + index);
    }

    public static int search(int[] sortedData, int target) {
        return searchHelper(sortedData, target, 0, sortedData.length - 1);
    }

    private static int searchHelper(int[] sortedData, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;

        if (sortedData[mid] == target) {
            return mid;
        }

        if (sortedData[mid] > target) {
            // go low
            return searchHelper(sortedData, target, low, mid - 1);
        } else {
            // go high
            return searchHelper(sortedData, target, mid + 1, high);
        }
    }
}
