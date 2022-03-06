package org.mauro.algorithms.sort;

import java.util.Arrays;

import static org.mauro.Entries.QUICK_SORT;

public class QuickSort {
    public void solution() {
        System.out.println(Arrays.toString(sort(QUICK_SORT)));
    }

    public int[] sort(final int[] values) {
        System.out.println(Arrays.toString(values));
        return sorting(values);
    }

    private int[] sorting(int[] values) {
        int size = values.length;
        int[] cache = new int[size];
        int pivotPointer = size / 2;
        int leftPointer = 0;
        int rightPointer = size - 1;
        for (int i = 0; i < size; i++) {
            if (pivotPointer != i) {
                if (values[i] < values[pivotPointer]) {
                    cache[leftPointer++] = values[i];
                } else {
                    cache[rightPointer--] = values[i];
                }
            }
        }
        cache[leftPointer] = values[pivotPointer];
        if (leftPointer > 1) {
            int[] leftSorted = sorting(Arrays.copyOfRange(cache, 0, leftPointer));
            for (int i = 0; i < leftPointer; i++) {
                cache[i] = leftSorted[i];
            }
        }
        if (rightPointer < size - 2) {
            int[] rightSorted = sorting(Arrays.copyOfRange(cache, rightPointer + 1, size));
            for (int i = 0, j = rightPointer + 1; i < rightSorted.length; i++, j++) {
                cache[j] = rightSorted[i];
            }
        }
        return cache;
    }
}
