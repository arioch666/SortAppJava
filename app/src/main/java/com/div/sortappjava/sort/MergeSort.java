package com.div.sortappjava.sort;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.div.sortappjava.utils.ComparableConstants.EQUAL;
import static com.div.sortappjava.utils.ComparableConstants.GREATER;
import static com.div.sortappjava.utils.ComparableConstants.LESS;

/**
 * Created by arioch666 on 11/12/17.
 */

public class MergeSort implements Sorter {

    Comparable[] values;

    private void mergeSort(int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int mid = (startIndex + endIndex) / 2;

            //Create a way to callback for highlights.
            mergeSort(startIndex, mid);
            mergeSort(mid+1, endIndex);
            merge(startIndex, endIndex);
        }
    }

    private void merge(int startIndex, int endIndex) {

        if(startIndex >= endIndex) {
            return;
        }

        int mid = (endIndex+startIndex)/2;
        //+1 for the index is because it is exclusive and not inclusive
        Comparable[] copyLeft = Arrays.copyOfRange(values, startIndex, mid);
        Comparable[] copyRigth = Arrays.copyOfRange(values, mid, endIndex);

        int i = 0;
        int j = 0;
        int traverser = startIndex;

        while (i < copyLeft.length  && j < copyRigth.length) {
            if (copyLeft[i] == null) {
                System.out.print("left null for start index: " + startIndex + " endindex: "+endIndex + " copyleft.length:" + copyLeft.length
                        + " copyRight.length:" + copyRigth.length + " mid:" + mid);
            } else if (copyRigth[j] == null) {
                System.out.print("right null for start index: " + startIndex + " endindex: "+endIndex + " copyleft.length:" + copyLeft.length
                        + " copyRight.length:" + copyRigth.length + " mid:" + mid);
            }
            switch (copyLeft[i].compareTo(copyRigth[j])) {
                //Less than or equal
                case LESS:
                case EQUAL:
                    values[traverser++] = copyLeft[i++];
                    break;
                case GREATER:
                    values[traverser++] = copyRigth[j++];
                    break;
            }
        }

        while(i < copyLeft.length) {
            values[traverser++] = copyLeft[i++];
        }

        while(j < copyRigth.length) {
            values[traverser++] = copyRigth[j++];
        }

    }

    @Override
    public void sort(Comparable[] values) {
        this.values = values;
        mergeSort(0, values.length);
    }
}
