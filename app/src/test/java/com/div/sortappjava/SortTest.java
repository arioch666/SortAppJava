package com.div.sortappjava;

import com.div.sortappjava.sort.InsertionSort;
import com.div.sortappjava.sort.MergeSort;
import com.div.sortappjava.sort.QuickSort;
import com.div.sortappjava.sort.SelectionSort;
import com.div.sortappjava.sort.Sorter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.Assert.fail;

/**
 * Created by arioch666 on 11/12/17.
 */
public class SortTest {

    Integer[] integersToSort;
    private int length;
    private Sorter sorter;

    @Before
    public void setUp() {
        integersToSort = new Integer[]{1,6,7,3,19,5};
        length = integersToSort.length;
    }

    @Test
    public void testMergeSort() {
        sorter = new MergeSort();
    }

    @Test
    public void testInsertionSort() {
        sorter = new InsertionSort();
    }

    @Test
    public void testQuickSort() {
        sorter = new QuickSort();
    }

    @Test
    public void testSelectionSort() {
        sorter = new SelectionSort();
    }

    @After
    public void checkResult() {
        sorter.sort(integersToSort);

        for (int i = 0; i < length-1; i++) {
            if(integersToSort[i] > integersToSort[i+1]) {
                fail("Not Sorted");
            }
        }

        assertTrue(true);
    }
}
