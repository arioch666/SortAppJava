package com.div.sortappjava.ui.model.interfaces;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

/**
 * Created by arioch666 on 11/13/17.
 */

public interface MainFragmentModel {

    void setSize(int size);
    void setInitilizationType(int initializationType);
    MutableLiveData<Integer> getSize();
    Integer getInitializationType();

}
