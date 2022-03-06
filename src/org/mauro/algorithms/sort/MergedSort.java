package org.mauro.algorithms.sort;

import java.util.Arrays;

import static org.mauro.Entries.MERGE_SORT;

public class MergedSort {
    public void solution() {
        System.out.println(Arrays.toString(sort(MERGE_SORT)));
    }

    public int[] sort(final int[] values) {
        System.out.println(Arrays.toString(values));
        return sorting(values);
    }

    private int[] sorting(int[] values) {
        int size = values.length;
        int medium = size / 2;
        int [] leftSide = new int[medium];
        int [] rightSide = new int[size - medium];
        if (medium > 1) {
            leftSide = sorting(Arrays.copyOfRange(values, 0, medium));
        } else {
            leftSide[0] = values[0];
        }
        if (size - medium > 1) {
            rightSide = sorting(Arrays.copyOfRange(values, medium, size));
        } else {
            rightSide[0] = values[size - 1];
        }
        return merging(leftSide, rightSide);
    }

    private int[] merging(final int[] leftSide, final int[] rightSide) {
        int[] cache = new int[leftSide.length + rightSide.length];
        int cachePointer = 0;
        int last = 0;
        for (int i=0; i<leftSide.length; i++) {
            for (int j=0; j<rightSide.length; j++) {
                if (leftSide[i] > i) {
                    cache[cachePointer++] = rightSide[j];
                } else {
                    cache[cachePointer++] = leftSide[i];
                }
            }

        }
        cache[cachePointer] = last;
        return cache;
    }
}
