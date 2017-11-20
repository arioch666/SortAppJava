package com.div.sortappjava.ui.model;

import com.div.sortappjava.ui.SortObject;
import com.div.sortappjava.ui.model.interfaces.SortFragmentModel;

/**
 * Created by arioch666 on 11/14/17.
 */

public class SortFragmentModelImpl implements SortFragmentModel {

    SortObject[] sortObjects;

    @Override
    public SortObject[] getData() {
        return sortObjects;
    }

    @Override
    public void setData(SortObject[] sortObjects) {
        this.sortObjects = sortObjects;
    }
}
