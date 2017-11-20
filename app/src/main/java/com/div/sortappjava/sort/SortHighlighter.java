package com.div.sortappjava.sort;

/**
 * Created by arioch666 on 11/13/17.
 *
 * Ok, Ill admit im tired, This is an effort to get the highlighting done.
 *
 * Will pass in the interface object in the constructor. that way i can modify the tests to check
 * the object is being highlighted.
 *
 * This also allows me to create an object that can be used as a MutableLiveData that i can use
 * to dispatch events to the recycler view.
 *
 * Im sure there is a better way of doing this so I will keep it as a todo.
 *
 * LiveData is still slightly abstract since i have not used it yet. this may actually be unnecessary.
 *
 */

public interface SortHighlighter {

    void highlight(Integer... values);

    void highlightRange(int startIndex, int endIndex);

    void highlightSorted();

}
