package com.div.sortappjava.ui.fragments.interfaces;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;

/**
 * Created by arioch666 on 11/14/17.
 */

public interface SortTypeFragmentView {

    Button getContinueButton();
    RecyclerView getSortTypeRecyclerView();

    void showNoneSelectedError();
}
