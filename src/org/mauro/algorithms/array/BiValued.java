package org.mauro.algorithms.array;

import java.util.HashMap;
import java.util.Map;

import static org.mauro.Entries.BI_VALUED;

public class BiValued {
    public void solution() {
        System.out.println(getBiValued(BI_VALUED));
    }

    public int getBiValued(final int[] values) {
        final Map<Integer, Item> items = new HashMap<>();
        Item bivaluedA = new Item(-1, 0);
        Item bivaluedB = new Item(-1, 0);
        for (int value : values) {
            Item item = items.get(value);
            if (item == null) {
                item = new Item(value, 1);
                items.put(value, item);
            } else {
                item.increase();
            }
            if (item.isBigger(bivaluedA)) {
                Item cache = bivaluedA;
                bivaluedA = item;
                if (cache.isBigger(bivaluedB) || bivaluedB.value != bivaluedA.value) {
                    bivaluedB = cache;
                }
            } else if (item.isBigger(bivaluedB) && bivaluedB.value == bivaluedA.value) {
                bivaluedB = item;
            }
        }

        System.out.println("items: " + items);
        System.out.println("biValueA: " + bivaluedA + ", biValueB: " + bivaluedB);
        return bivaluedA.counter + bivaluedB.counter;
    }

    static class Item {
        int value;
        int counter;

        public Item(int value, int counter) {
            this.value = value;
            this.counter = counter;
        }

        public void increase() {
            counter++;
        }

        public boolean isBigger(final Item comparator) {
            return comparator.counter < counter;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", counter=" + counter +
                    '}';
        }
    }
}