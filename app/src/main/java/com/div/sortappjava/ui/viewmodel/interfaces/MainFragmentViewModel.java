package com.div.sortappjava.ui.viewmodel.interfaces;

import android.support.v4.app.Fragment;

import com.div.sortappjava.ui.fragments.interfaces.MainFragmentView;
import com.div.sortappjava.ui.model.interfaces.MainFragmentModel;

/**
 * Created by arioch666 on 11/14/17.
 */

public interface MainFragmentViewModel {

    MainFragmentModel getMainFragmentModel();

    void setMainFragmentView(MainFragmentView mainFragmentView);

    void bindSeekBarChangeToModel();
    void bindSizeTextViewToModel();
    void bindRadioGroup();
    void bindContinueButton();
}
