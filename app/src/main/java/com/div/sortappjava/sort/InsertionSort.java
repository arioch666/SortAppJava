package com.div.sortappjava.sort;

import static com.div.sortappjava.utils.ComparableConstants.GREATER;

/**
 * Created by arioch666 on 11/12/17.
 */

public class InsertionSort implements Sorter {

    Comparable[] values;

    @Override
    public void sort(Comparable[] values) {
        this.values = values;
        insertionSort(values.length-1);
    }

    private void insertionSort(int sortLength) {

        //Base case
        if (sortLength <= 1) {
            return;
        }

        insertionSort(sortLength - 1);

        Comparable last = values[sortLength];
        int traverse = sortLength-1;

        while (traverse >= 0
                && values[traverse].compareTo(last) == GREATER) {
            values[traverse+1] = values[traverse--];
        }
        values[traverse+1] = last;
    }
}
