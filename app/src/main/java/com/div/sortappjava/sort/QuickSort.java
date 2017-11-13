package com.div.sortappjava.sort;

import static com.div.sortappjava.utils.Constants.ComparableConstants.EQUAL;
import static com.div.sortappjava.utils.Constants.ComparableConstants.LESS;

/**
 * Created by arioch666 on 11/12/17.
 * Performs quick sort of the array that is sent in to the {@link QuickSort#sort(Comparable[])}
 *
 * The array must be of type Comparable and is stored in the {@link AbstractSort#values}
 */

public class QuickSort extends AbstractSort {

    /**
     * From the {@link Sorter} that is implemented by {@link AbstractSort}
     *
     * @param values saved to {@link AbstractSort#values}
     */
    @Override
    public void sort(Comparable[] values) {
        this.values = values;
        quickSort(0, values.length-1);
    }

    private void quickSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            //select partitioning index
            int partitioningIndex = partition(startIndex, endIndex);

            /**
             * at this point the {@see partitioningIndex} is in the sorted position
             * i.e. all elements to the right are greater and all elements to the left are smaller
             */
            quickSort(startIndex, partitioningIndex-1);
            quickSort(partitioningIndex+1, endIndex);
        }
    }

    /**
     * The start and end index of the portion of the array we want to partition,
     *
     * @param startIndex
     * @param endIndex
     * @return the index of the value that we placed in the method.
     * It should be in its sorted position
     *
     * The last element in the array is chosen as the pivot or swap comparison object.
     *
     * the elements are compared with the pivot.
     *
     * Elements that are greater than the pivot will end up on its right once it is placed.
     * These elements may not be is sorted order the only guarantee is they will be greater
     *
     * Similarly the elements on the left of the pivot once it is placed will be less than but in
     * no specific order.
     */
    private int partition(int startIndex, int endIndex) {
        Comparable pivot = values[endIndex];

        int swapIndex = startIndex-1; //can be -1

        //we want to traverse all elements upto the last -1 since we want to place that element
        for (int traverse = startIndex; traverse < endIndex; traverse++) {
            switch (values[traverse].compareTo(pivot)) {
                case LESS:
                case EQUAL:
                    /**
                     * Each time we swap we want to increase the swap index so the next element will
                     * be in the new swap index location.
                     */
                    swap(++swapIndex, traverse);
                    break;
            }
        }

        /**
         * this is where the pivot element gets placed. At this point it is in its sorted position
         * in the {@link AbstractSort#values} array
         */
        swap(++swapIndex, endIndex);

        return swapIndex;
    }
}
