package com.div.sortappjava.sort;

import com.div.sortappjava.utils.enums.SortTypeEnum;

/**
 * Created by arioch666 on 11/13/17.
 *
 * Using package private for the visibility
 *
 * Creates a small template that the sort classes will use.
 *
 * They need an array of Comparable and a way to swap them,
 *
 * The update to create an abstract class was due to the repeated code in the sort classes.
 *
 */
abstract class AbstractSort implements Sorter {

    Comparable[] values;
    int length;

    SortHighlighter sortHighlighter;

    SortTypeEnum sortTypeEnum;

    /**
     *
     * Simple Swap function that will swap the values at the locations specified by:
     * @param index1 integer param that is the index of an object we want to swap
     * @param index2 integer param that is the index of the other object we want to swap with.
     */
    void swap(int index1, int index2) {
        Comparable tempObject = values[index1];
        values[index1] = values[index2];
        values[index2] = tempObject;
        highlight(index1,index2);

    }

    void pause() {
        try {
            synchronized (this ) {
                wait(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setSortHighlighter(SortHighlighter sortHighlighter) {
        this.sortHighlighter = sortHighlighter;
    }

    public void highlight(Integer... values) {
        if (sortHighlighter != null) {
            sortHighlighter.highlight(values);
            pause();
        }
    }

    public void highlightRange(int startIndex, int endIndex){
        if (sortHighlighter != null) {
            sortHighlighter.highlightRange(startIndex, endIndex);
        }
    }

    private void highlightSorted() {
        if (sortHighlighter != null) {
            sortHighlighter.highlightSorted();
        }
    }

    @Override
    public SortTypeEnum getSortTypeEnum() {
        return sortTypeEnum;
    }
}
