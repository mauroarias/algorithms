package org.mauro.algorithms.array;

import java.util.HashSet;
import java.util.Set;

import static org.mauro.Entries.DUPLICATE;

public class Duplicate {
    public void solution() {
        System.out.println(isDuplicate(DUPLICATE));
    }

    public boolean isDuplicate(final String value) {
        Set<Character> items = new HashSet<>();
        for (Character item : value.toCharArray()) {
            if (items.contains(item)) {
                return true;
            }
            items.add(item);
        }
        return false;
    }
}
