package com.josh.sorts;

abstract class BaseSort {
    static void printArray(int[] array) {

        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.print(array[i]);
            } else {
                System.out.print(array[i] + ", ");
            }
        }

        System.out.println();
    }

    static void swap(int[] array, int source, int dest) {
        int temp = array[dest];

        array[dest] = array[source];
        array[source] = temp;
    }

    static int[] spliceArray(int[] array, int start, int end) {
        int[] splice = new int[end - start];

        System.arraycopy(array, start, splice, 0, end - start);

        return splice;
    }
}
