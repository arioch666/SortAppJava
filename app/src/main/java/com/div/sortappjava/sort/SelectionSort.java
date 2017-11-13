package com.div.sortappjava.sort;

/**
 * Created by arioch666 on 11/13/17.
 */

public class SelectionSort implements Sorter {
    Comparable[] values;

    @Override
    public void sort(Comparable[] values) {
        this.values = values;
    }
}
