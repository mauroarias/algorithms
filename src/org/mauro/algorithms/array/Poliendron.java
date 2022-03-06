package org.mauro.algorithms.array;

import org.mauro.Entries;

public class Poliendron {
    public void solution() {
        System.out.println(isPoliendre(Entries.POLIENDRON));
    }

    public boolean isPoliendre(final String value) {
        final char[] asChar = value.toCharArray();

        for (int i = 0; i < value.length()/2; i++) {
            if (asChar[i] != asChar[value.length() - 1 - i]) {
                return false;
            }
        }
        return true;
    }
}
