package com.div.sortappjava.sort;


import static com.div.sortappjava.utils.Constants.ComparableConstants.EQUAL;
import static com.div.sortappjava.utils.Constants.ComparableConstants.LESS;

/**
 * Created by arioch666 on 11/13/17.
 *
 * Performs selection sort of the array that is sent in to the {@link SelectionSort#sort(Comparable[])}
 *
 * The array must be of type Comparable and is stored in the {@link AbstractSort#values}
 */

public class SelectionSort extends AbstractSort {

    /**
     * From the {@link Sorter} that is implemented by {@link AbstractSort}
     *
     * @param values saved to {@link AbstractSort#values}
     */
    @Override
    public void sort(Comparable[] values) {
        this.values = values;
        this.length = values.length;
        selectionSort(0);
    }

    /**
     * The sorted endIndex is the value of the current sorted end index starting from 0.
     *
     * The array is split into 2 parts, sorted [0 to {@param sortedEndIndex}] and
     * unsorted[{@param sortedEndIndex} to length-1]
     *
     * @param sortedEndIndex is the end index of the sorted portion of the array initially 0;
     *                       will increment in values of 1 as {@method selectionSort} gets called
     *                       recursively.
     *
     *
     */
    private void selectionSort(int sortedEndIndex) {
        if (sortedEndIndex >= length-1) {
            return;
        }

        int minIndex = findMin(sortedEndIndex, length-1);

        /**
         * @see AbstractSort#sort(Comparable[])
         */
        swap(minIndex, sortedEndIndex++);

        //recursive call
        selectionSort(sortedEndIndex);
    }

    /**
     * finds the min value in the search space specified within the {@param startIndex}
     * & {@param endIndex} once found it returns the index of that value in
     * the {@link AbstractSort#values} array.
     *
     * @param startIndex int value of the start index from where we wish to find the min
     * @param endIndex int value of the end index for the search space in the array
     * @return the index of the min element in the {@link AbstractSort#values}
     */
    private int findMin(int startIndex, int endIndex) {
        if (startIndex >= endIndex) {
            return endIndex;
        }

        //initially the min index is the start index.
        int minIndex = startIndex;

        for (int traverse = startIndex; traverse <= endIndex; traverse++) {
            //Compare the current position value to the min value.
            switch (values[traverse].compareTo(values[minIndex])) {
                case LESS:
                case EQUAL:
                    //change the min index value since the current value is smaller.
                    minIndex = traverse;
                    break;
            }
        }

        return minIndex;
    }
}
