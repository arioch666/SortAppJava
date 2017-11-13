package com.div.sortappjava.sort;

/**
 * Created by arioch666 on 11/12/17.
 */

public class InsertionSort<T extends Comparable<? super T>> implements Sorter {

    T[] values;

    public InsertionSort(T[] values) {
        this.values = values;
    }

    @Override
    public void sort() {
        insertionSort(values.length-1);
    }

    private void insertionSort(int sortLength) {

        //Base case
        if (sortLength <= 1) {
            return;
        }

        insertionSort(sortLength - 1);

        T last = values[sortLength];
        int traverse = sortLength-1;

        while (traverse >= 0
                && values[traverse].compareTo(last) > 0) {
            values[traverse+1] = values[traverse--];
        }
        values[traverse+1] = last;
    }
}
