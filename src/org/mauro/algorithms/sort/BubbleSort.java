package org.mauro.algorithms.sort;

import java.util.Arrays;

import static org.mauro.Entries.SORT;

public class BubbleSort {
    public void solution() {
        System.out.println(Arrays.toString(sort(SORT)));
    }

    public int[] sort(final int[] values) {
        System.out.println(Arrays.toString(values));
        int untilPointer = values.length - 1;
        for (int i = 0; i < untilPointer; i++) {
            for (int j = 0; j < untilPointer - i; j++) {
                int nextPointer = j + 1;
                if (values[j] > values[nextPointer]) {
                    int cache = values[nextPointer];
                    values[nextPointer] = values[j];
                    values[j] = cache;
                }
            }
        }
        return values;
    }
}
