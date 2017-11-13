package com.div.sortappjava;

import com.div.sortappjava.sort.MergeSort;
import com.div.sortappjava.sort.Sorter;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by arioch666 on 11/12/17.
 */
public class SortTest {

    Integer[] integersToSort;

    @Before
    public void setUp() {
         integersToSort = new Integer[]{1,6,7,3,19,5};
    }

    @Test
    public void testMergeSort() {
        Sorter mergeSort = new MergeSort<>(integersToSort);
        mergeSort.sort();

        int length = integersToSort.length;

        for (int i = 0; i < length-1; i++) {
            if(integersToSort[i] > integersToSort[i+1]) {
                fail("Not Sorted");
            }
        }

        assertTrue(true);
    }


}
