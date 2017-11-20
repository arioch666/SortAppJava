package com.div.sortappjava.ui.viewmodel.interfaces;

import com.div.sortappjava.datagenerator.interfaces.DataGenerator;
import com.div.sortappjava.ui.fragments.interfaces.SortFragmentView;
import com.div.sortappjava.ui.model.interfaces.SortFragmentModel;

/**
 * Created by arioch666 on 11/14/17.
 */

public interface SortFragmentViewModel {

    SortFragmentModel getSortFragmentModel();

    void setSortFragmentView(SortFragmentView sortFragmentView);

    void bindRecyclerView();

    void setDataGenerator(DataGenerator dataGenerator);

    void bindBeginSortButton();
}
