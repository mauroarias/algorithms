package org.mauro.algorithms.search;

import static org.mauro.Entries.LOOK_FOR;
import static org.mauro.Entries.SEARCH;

public class LinearSearch {
    public void solution() {
        System.out.println(isThere(SEARCH, LOOK_FOR));
    }

    public boolean isThere(final int[] values, final int lookingFor) {
        for (int value : values) {
            if (value == lookingFor) {
                return true;
            }
        }
        return false;
    }
}
