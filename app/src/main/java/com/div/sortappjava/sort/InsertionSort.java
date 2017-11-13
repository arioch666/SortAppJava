package com.div.sortappjava.sort;

import static com.div.sortappjava.utils.ComparableConstants.GREATER;

/**
 * Created by arioch666 on 11/12/17.
 *
 * Performs merge sort of the array that is sent in to the {@link InsertionSort#sort(Comparable[])}
 *
 * The array must be of type Comparable and is stored in the {@link AbstractSort#values}
 */

public class InsertionSort extends AbstractSort {

    /**
     * From the {@link Sorter} that is implemented by {@link AbstractSort}
     *
     * @param values saved to {@link AbstractSort#values}
     */
    @Override
    public void sort(Comparable[] values) {
        this.values = values;
        this.length = values.length;
        insertionSort(length-1);
    }

    /**
     *
     * Sorts the array by recursively calling sort till it reaches the 1st element and then
     * come back up the call stack sorting from the last element to first and shifting elements
     * to the right by one if they are greater than the last element, i.e. the element at the array
     * index from the start
     *
     * @param sortLength used to determine how much of the array needs sorting.
     */
    private void insertionSort(int sortLength) {

        //Base case
        if (sortLength <= 1) {
            return;
        }

        //call itself
        insertionSort(sortLength - 1);

        //get the last element before we start swapping
        Comparable last = values[sortLength];
        int traverse = sortLength-1;

        //Keep going back through the array from right to left and check if the element is greater
        //than the currently selected one.
        while (traverse >= 0
                && values[traverse].compareTo(last) == GREATER) {
            values[traverse+1] = values[traverse--];
        }

        //Insert the element into the position we have determined for it.
        values[traverse+1] = last;
    }
}
