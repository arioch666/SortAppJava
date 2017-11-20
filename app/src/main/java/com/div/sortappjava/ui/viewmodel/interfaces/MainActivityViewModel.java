package com.div.sortappjava.ui.viewmodel.interfaces;

import com.div.sortappjava.ui.activities.interfaces.MainActivityView;
import com.div.sortappjava.ui.model.interfaces.MainFragmentModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arioch666 on 11/14/17.
 *
 * Not an architecture viewmodel but the implementation will be.
 */

public interface MainActivityViewModel {
    void setMainActivityView(MainActivityView mainActivityView);

    ArrayList<Integer> getSortTypeList();

}