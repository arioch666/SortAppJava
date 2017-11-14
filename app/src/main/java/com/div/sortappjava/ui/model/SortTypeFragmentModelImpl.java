package com.div.sortappjava.ui.model;

import com.div.sortappjava.ui.model.interfaces.SortTypeFragmentModel;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by arioch666 on 11/14/17.
 */

public class SortTypeFragmentModelImpl implements SortTypeFragmentModel {
    Set<Integer> sortTypes = new HashSet<>();

    @Override
    public void addSortType(int sortType) {
        sortTypes.add(sortType);
    }

    @Override
    public void removeSortType(int sortType) {
        sortTypes.remove(sortType);
    }

    @Override
    public Set<Integer> getSortType() {
        return sortTypes;
    }
}
