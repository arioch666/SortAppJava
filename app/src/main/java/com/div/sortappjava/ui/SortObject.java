package com.div.sortappjava.ui;

import android.arch.lifecycle.MutableLiveData;

import com.div.sortappjava.sort.MergeSort;
import com.div.sortappjava.sort.SortHighlighter;
import com.div.sortappjava.sort.Sorter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by arioch666 on 11/13/17.
 */

public class SortObject<T extends Comparable<? super T>> implements SortHighlighter {

    private MutableLiveData<T[]> values;
    private MutableLiveData<Set<Integer>> highlightIndices;
    private MutableLiveData<Integer[]> range;
    private MutableLiveData<Boolean> sorted;
    private Sorter<T> sorter;
    private int maxValue;



    public SortObject() {
        values = new MutableLiveData<>();
        highlightIndices = new MutableLiveData<>();
        range = new MutableLiveData<>();
        sorter = new MergeSort();
        sorted = new MutableLiveData<>();
    }

    public MutableLiveData<T[]> getValues() {
        return values;
    }

    public void setValues(T[] values) {
        this.values.setValue(values);
    }

    public MutableLiveData<Set<Integer>> getHighlightIndices() {
        return highlightIndices;
    }

    public void setHighlightIndices(Set<Integer> highlightIndices) {
        this.highlightIndices.setValue(highlightIndices);
    }

    public MutableLiveData<Integer[]> getRange() {
        return range;
    }

    public void setRange(Integer[] range) {
        this.range.setValue(range);
    }

    public Sorter<T> getSorter() {
        return sorter;
    }

    public void setSorter(Sorter<T> sorter) {
        this.sorter = sorter;
        this.sorter.setSortHighlighter(this);
    }

    @Override
    public void highlight(Integer... values) {
        Set<Integer> highlightIndices = new HashSet<>();
        highlightIndices.addAll(Arrays.asList(values));

        /**
         * Expecting the value to be ser from a different thread by using post value it will get
         * posted on the main thread.
         */
        this.highlightIndices.postValue(highlightIndices);
    }

    @Override
    public void highlightRange(int startIndex, int endIndex) {
        range.postValue(new Integer[]{startIndex, endIndex});
    }

    @Override
    public void highlightSorted() {
        sorted.postValue(true);
    }

    public MutableLiveData<Boolean> getSorted() {
        if (sorted.getValue() == null) {
            sorted.setValue(false);
        }
        return sorted;
    }

    public int getMaxValue() {
        return maxValue;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void startSorting() {
        getSorter().sort(values.getValue());
    }
}
