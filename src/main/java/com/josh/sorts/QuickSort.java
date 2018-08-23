package com.josh.sorts;

public class QuickSort extends BaseSort {
    public static void main(String[] args) {
        int[] input = new int[]{5, 4, 3, 1, 9};

        quickSort(input, 0, input.length - 1);

        printArray(input);
    }

    private static void quickSort(int[] input, int start, int end) {

        if (start < end) {
            int pivot = partition(input, start, end);
            quickSort(input, start, pivot - 1);
            quickSort(input, pivot + 1, end);
        }
    }

    private static int partition(int[] input, int start, int end) {
        int pivot = input[start];
        int leftMarker = start;
        int rightMarker = end;

        while (true) {
            while (leftMarker <= rightMarker && input[leftMarker] <= pivot) {
                leftMarker++;
            }

            while (rightMarker >= leftMarker && input[rightMarker] >= pivot) {
                rightMarker--;
            }

            if (rightMarker < leftMarker) {
                break;
            } else {
                swap(input, leftMarker, rightMarker);
            }
        }

        // swap
        swap(input, start, rightMarker);

        return rightMarker;
    }
}
