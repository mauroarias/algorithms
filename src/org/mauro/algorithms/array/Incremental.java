package org.mauro.algorithms.array;

import java.util.Arrays;

import static org.mauro.Entries.INCREMENTAL;

public class Incremental {
    public void solution() {
        System.out.println(Arrays.toString(incremental(INCREMENTAL)));
    }

    public int[] incremental(final int[] arr) {
        int interactionNumber = 0;
        int[] values = arr;
        while (!areAllEquals(values)) {
            values = incrementAllExceptPointed(values);
            interactionNumber++;
        }
        System.out.println("interactions: " + interactionNumber);
        return values;
    }

    public int findMaxPointer(final int[] values) {
        int pointerMaxValue = 0;
        for(int i = 0; i < values.length; i++) {
            if (values[pointerMaxValue] < values[i]) {
                pointerMaxValue = i;
            }
        }
        return pointerMaxValue;
    }

    public boolean areAllEquals(final int[] values) {
        boolean allEquals = true;
        int lastValueCache = values[0];
        for(int value : values) {
            allEquals = lastValueCache == value && allEquals;
        }
        return allEquals;
    }

    public int[] incrementAllExceptPointed(final int[] values) {
        int pointerMinValue = findMaxPointer(values);
        for(int i = 0; i < values.length; i++) {
            if (i != pointerMinValue) {
                values[i]++;
            }
        }
        return values;
    }
}