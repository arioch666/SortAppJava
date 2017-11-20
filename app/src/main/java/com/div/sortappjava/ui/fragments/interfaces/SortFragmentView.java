package com.div.sortappjava.ui.fragments.interfaces;

import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.FrameLayout;

import java.util.List;

/**
 * Created by arioch666 on 11/13/17.
 */

public interface SortFragmentView {

    RecyclerView getRecyclerView();

    List<Integer> getSortTypeList();

    FrameLayout getSortOverlay();

    Button getBeginSortButton();

    void hideOverlay();
}
