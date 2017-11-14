package com.div.sortappjava.ui;

import android.arch.lifecycle.MutableLiveData;

import com.div.sortappjava.sort.MergeSort;
import com.div.sortappjava.sort.Sorter;

import java.util.List;

/**
 * Created by arioch666 on 11/13/17.
 */

public class SearchObject<T extends Comparable<? super T>> {

    MutableLiveData<T[]> values;
    MutableLiveData<Integer[]> highlightIndices;
    MutableLiveData<Integer[]> range;
    MutableLiveData<List<Integer>> sortedRange;
    Sorter<T> sorter;

    public SearchObject() {
        values = new MutableLiveData<>();
        highlightIndices = new MutableLiveData<>();
        range = new MutableLiveData<>();
        sorter = new MergeSort();
    }

    public MutableLiveData<T[]> getValues() {
        return values;
    }

    public void setValues(MutableLiveData<T[]> values) {
        this.values = values;
    }

    public MutableLiveData<Integer[]> getHighlightIndices() {
        return highlightIndices;
    }

    public void setHighlightIndices(MutableLiveData<Integer[]> highlightIndices) {
        this.highlightIndices = highlightIndices;
    }

    public MutableLiveData<Integer[]> getRange() {
        return range;
    }

    public void setRange(MutableLiveData<Integer[]> range) {
        this.range = range;
    }

    public Sorter<T> getSorter() {
        return sorter;
    }

    public void setSorter(Sorter<T> sorter) {
        this.sorter = sorter;
    }
}
