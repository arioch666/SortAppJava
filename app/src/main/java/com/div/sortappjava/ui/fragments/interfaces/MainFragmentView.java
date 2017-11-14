package com.div.sortappjava.ui.fragments.interfaces;

import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

/**
 * Created by arioch666 on 11/13/17.
 */

public interface MainFragmentView {

    SeekBar getSeekBar();
    Button getContinueButton();
    TextView getSizeTextView();
    RadioGroup getRadioGroup();

    void showSizeError();
}
