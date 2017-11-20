package com.div.sortappjava.sort;

import com.div.sortappjava.utils.enums.SortTypeEnum;

/**
 * Created by arioch666 on 11/12/17.
 *
 * This interface provides the basic sort method that all the sorting
 * classes will implement in order to perform the sort.
 *
 * The abstraction provided by the interface allows swapability, i.e.
 * we can switch out one sort provider for another without the consumer
 * knowing which sort is being used.
 *
 * Allows for a cleaner implementation.
 */

public interface Sorter<T extends Comparable<? super T>> {

    /**
     * @param values is the array of {@link Comparable} objects that need sorting
     */
    void sort(T[] values);

    SortTypeEnum getSortTypeEnum();

    void setSortHighlighter(SortHighlighter sortHighlighter);
}
