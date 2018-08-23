package com.josh.sorts;

public class MergeSort extends BaseSort {
    public static void main(String[] args) {

        int[] input = new int[]{5, 4, 3, 1, 9, -1, 20, 7, 3, 10, 14};

        int[] sorted = mergeSort(input);
        printArray(sorted);
    }

    private static int[] mergeSort(int[] input) {
        if (input.length < 2) {
            return input;
        }

        int[] left = spliceArray(input, 0, input.length / 2);
        int[] right = spliceArray(input, input.length / 2, input.length);

        return merge(mergeSort(left), mergeSort(right));
    }

    private static int[] merge(int[] sortedLeft, int[] sortedRight) {
        int[] result = new int[sortedLeft.length + sortedRight.length];
        int curIndex = 0;
        int leftIndex, rightIndex;

        for (leftIndex = 0, rightIndex = 0; leftIndex < sortedLeft.length && rightIndex < sortedRight.length;) {
            if (sortedLeft[leftIndex] < sortedRight[rightIndex]) {
                result[curIndex] = sortedLeft[leftIndex];
                curIndex++;
                leftIndex++;
            } else {
                result[curIndex] = sortedRight[rightIndex];
                curIndex++;
                rightIndex++;
            }
        }

        if (curIndex < result.length) {
            while (leftIndex < sortedLeft.length) {
                result[curIndex] = sortedLeft[leftIndex];
                curIndex++;
                leftIndex++;
            }

            while (rightIndex < sortedRight.length) {
                result[curIndex] = sortedRight[rightIndex];
                curIndex++;
                rightIndex++;
            }
        }

        return result;
    }
}
