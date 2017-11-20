package com.div.sortappjava.ui.model.interfaces;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arioch666 on 11/14/17.
 */

public interface SortTypeFragmentModel {

    void addSortType(Integer sortType);
    void removeSortType(Integer sortType);
    ArrayList<Integer> getSortType();


}
