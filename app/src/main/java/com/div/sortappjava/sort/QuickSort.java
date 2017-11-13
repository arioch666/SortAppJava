package com.div.sortappjava.sort;

import java.util.Arrays;

import static com.div.sortappjava.utils.ComparableConstants.EQUAL;
import static com.div.sortappjava.utils.ComparableConstants.GREATER;
import static com.div.sortappjava.utils.ComparableConstants.LESS;

/**
 * Created by arioch666 on 11/12/17.
 *
 * This class is used to create a sorting on an object
 */

public class QuickSort implements Sorter {
    private Comparable[] values;

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

    private int partition(int startIndex, int endIndex) {
        Comparable pivot = values[endIndex];
        Comparable swapObject;

        int swapIndex = startIndex-1; //can be -1

        //we want to traverse all elements upto the last -1 since we want to place that element
        for (int traverse = startIndex; traverse < endIndex; traverse++) {
            switch (values[traverse].compareTo(pivot)) {
                case LESS:
                case EQUAL:
                    swapObject = values[++swapIndex];
                    values[swapIndex]=values[traverse];
                    values[traverse] = swapObject;
                    break;
            }
        }

        swapObject = values[++swapIndex];
        values[swapIndex] = pivot;
        values[endIndex] = swapObject;

        return swapIndex;
    }
}
