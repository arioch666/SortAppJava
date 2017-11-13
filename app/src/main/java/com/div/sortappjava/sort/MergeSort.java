package com.div.sortappjava.sort;

import java.util.Arrays;

import static com.div.sortappjava.utils.Constants.ComparableConstants.EQUAL;
import static com.div.sortappjava.utils.Constants.ComparableConstants.GREATER;
import static com.div.sortappjava.utils.Constants.ComparableConstants.LESS;

/**
 * Created by arioch666 on 11/12/17.
 *
 * Performs merge sort of the array that is sent in to the {@link MergeSort#sort(Comparable[])}
 *
 * The array must be of type Comparable and is stored in the {@link AbstractSort#values}
 */

public class MergeSort extends AbstractSort {

    /**
     * From the {@link Sorter} that is implemented by {@link AbstractSort}
     *
     * @param values saved to {@link AbstractSort#values}
     */
    @Override
    public void sort(Comparable[] values) {
        this.values = values;
        this.length = values.length;
        mergeSort(0, length);
    }

    /**
     * Performs Merge Sort on the {@link AbstractSort#values}
     * called in the {@link MergeSort#sort(Comparable[])} method.
     *
     * Calls itself recursively splitting into 2 arrays each half the size of the original
     *
     * Once merge is called on each of the 2 arrays they are sorted.
     *
     * @param startIndex Start Index for the mergeSort
     * @param endIndex End Index for the mergeSort
     */
    private void mergeSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;

            //Create a way to callback for highlights.
            mergeSort(startIndex, mid);
            mergeSort(mid+1, endIndex);
            merge(startIndex, endIndex);
        }
    }

    /**
     * Merges the 2 arrays represented by the params
     * @param startIndex which is the starting index of the 1st array which ends at the middle element
     * and the second array starts at the middle element index + 1 and ends at the
     * @param endIndex
     *
     * A linear pass is made on the elements to place them in the appropriate position.
     */
    private void merge(int startIndex, int endIndex) {

        if(startIndex >= endIndex) {
            return;
        }

        int mid = (endIndex+startIndex)/2;
        Comparable[] copyLeft = Arrays.copyOfRange(values, startIndex, mid);
        Comparable[] copyRight = Arrays.copyOfRange(values, mid, endIndex);

        int i = 0;
        int j = 0;
        int traverser = startIndex;

        while (i < copyLeft.length  && j < copyRight.length) {
            switch (copyLeft[i].compareTo(copyRight[j])) {
                //Less than or equal
                case LESS:
                case EQUAL:
                    values[traverser++] = copyLeft[i++];
                    break;
                case GREATER:
                    values[traverser++] = copyRight[j++];
                    break;
            }
        }

        while(i < copyLeft.length) {
            values[traverser++] = copyLeft[i++];
        }

        while(j < copyRight.length) {
            values[traverser++] = copyRight[j++];
        }
    }
}
