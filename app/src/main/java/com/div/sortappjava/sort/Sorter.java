package com.div.sortappjava.sort;

/**
 * Created by arioch666 on 11/12/17.
 */

public interface Sorter<T extends Comparable<? super T>> {

    void sort(T[] T);
}
