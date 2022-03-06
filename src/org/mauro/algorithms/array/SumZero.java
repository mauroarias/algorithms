package org.mauro.algorithms.array;

import org.mauro.Entries;

import java.util.Arrays;

public class SumZero {
    public void solution() {
        System.out.println(Arrays.toString(getArrSumZero(Entries.SUM_ZERO)));
    }

    public int[] getArrSumZero(final int number) {
        int[] values = new int[number];
        for (int i = 0; i < number/2; i++) {
            int value = i + 1;
            int pointer = i * 2;
            values[pointer] = value;
            values[pointer + 1] = value * (-1);
        }
        return values;
    }
}
