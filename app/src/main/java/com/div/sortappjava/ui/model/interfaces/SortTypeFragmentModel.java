package com.div.sortappjava.ui.model.interfaces;

import java.util.Set;

/**
 * Created by arioch666 on 11/14/17.
 */

public interface SortTypeFragmentModel {

    void addSortType(int sortType);
    void removeSortType(int sortType);
    Set<Integer> getSortType();


}
