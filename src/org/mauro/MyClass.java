package org.mauro;

import org.mauro.algorithms.array.BiValued;
import org.mauro.algorithms.array.Duplicate;
import org.mauro.algorithms.array.Incremental;
import org.mauro.algorithms.array.Poliendron;
import org.mauro.algorithms.array.SumZero;
import org.mauro.algorithms.search.BinarySearch;
import org.mauro.algorithms.search.BinaryTree;
import org.mauro.algorithms.search.LinearSearch;
import org.mauro.algorithms.sort.BubbleSort;
import org.mauro.algorithms.sort.QuickSort;

public class MyClass {
    public static void main(String[] args) {
        new Poliendron().solution();
        new BiValued().solution();
        new Incremental().solution();
        new Duplicate().solution();
        new SumZero().solution();
        new BinarySearch().solution();
        new LinearSearch().solution();
        new BubbleSort().solution();
        new BinaryTree().solution();
        new QuickSort().solution();
//        new MergedSort().solution();
    }
}
