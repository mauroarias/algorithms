package org.mauro.algorithms.search;

import java.util.Arrays;

import static org.mauro.Entries.LOOK_FOR;
import static org.mauro.Entries.SEARCH;

public class BinarySearch {
    public void solution() {
        System.out.println(isThere(SEARCH, LOOK_FOR));
    }

    public boolean isThere(final int[] values, final int lookingFor) {
        final int[] sorted = Arrays.stream(values).sorted().toArray();
        int lowPointer = 0;
        int highPointer = values.length;
        while (lowPointer < highPointer) {
            int mediumPointer = ((highPointer - lowPointer) / 2) + lowPointer;
            if (sorted[mediumPointer] == lookingFor) {
                return true;
            }
            if (sorted[mediumPointer] > lookingFor) {
                highPointer = mediumPointer;
            } else {
                lowPointer = mediumPointer;
            }
        }
        return false;
    }
}
