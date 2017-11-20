package com.div.sortappjava.ui.model;

import android.arch.lifecycle.MutableLiveData;

import com.div.sortappjava.ui.model.interfaces.SortTypeFragmentModel;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by arioch666 on 11/14/17.
 */

public class SortTypeFragmentModelImpl implements SortTypeFragmentModel {
    ArrayList<Integer> sortTypes = new ArrayList<>();

    @Override
    public void addSortType(Integer sortType) {
        sortTypes.add(sortType);
    }

    @Override
    public void removeSortType(Integer sortType) {
        sortTypes.remove(sortType);
    }

    @Override
    public ArrayList<Integer> getSortType() {
        return sortTypes;
    }
}
