package com.div.sortappjava.ui.viewmodel.interfaces;

import com.div.sortappjava.ui.fragments.interfaces.SortTypeFragmentView;

/**
 * Created by arioch666 on 11/14/17.
 */

public interface SortTypeFragmentViewModel {

    void setSortTypeFragmentView(SortTypeFragmentView sortTypeFragmentView);

    void bindSortTypeRecyclerView();
    void bindSortTypeContinueButton();
}
