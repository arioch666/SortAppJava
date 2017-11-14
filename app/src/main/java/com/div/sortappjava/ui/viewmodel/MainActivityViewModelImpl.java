package com.div.sortappjava.ui.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.SearchObject;
import com.div.sortappjava.ui.activities.interfaces.MainActivityView;
import com.div.sortappjava.ui.fragments.interfaces.MainFragmentView;
import com.div.sortappjava.ui.model.MainFragmentModelImpl;
import com.div.sortappjava.ui.model.interfaces.MainFragmentModel;
import com.div.sortappjava.ui.viewmodel.interfaces.MainActivityViewModel;
import com.div.sortappjava.ui.viewmodel.interfaces.MainFragmentViewModel;

import static com.div.sortappjava.utils.Constants.DataGenerator.ASCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.DESCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.RANDOM;

/**
 * Created by arioch666 on 11/13/17.
 */

public class MainActivityViewModelImpl extends ViewModel implements MainActivityViewModel, MainFragmentViewModel {
    MainFragmentModel mainFragmentModel;
    MainFragmentView mainFragmentView;

    MainActivityView mainActivityView;


    @Override
    public MainFragmentModel getMainFragmentModel() {
        if (mainFragmentModel == null) {
            mainFragmentModel = new MainFragmentModelImpl();
        }

        return mainFragmentModel;
    }

    /**
     * For Testing
     * @param mainFragmentModel
     */
    public void setMainFragmentModel(MainFragmentModel mainFragmentModel) {
        this.mainFragmentModel = mainFragmentModel;
    }

    @Override
    public void setMainFragmentView(MainFragmentView mainFragmentView) {
        this.mainFragmentView = mainFragmentView;

        initializeMainFragmentView();
    }

    @Override
    public void bindSeekBarChangeToModel() {
        mainFragmentView.getSeekBar()
                .setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                    @Override
                    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                        getMainFragmentModel().setSize(i);
                    }

                    @Override
                    public void onStartTrackingTouch(SeekBar seekBar) {

                    }

                    @Override
                    public void onStopTrackingTouch(SeekBar seekBar) {

                    }
                });
        mainFragmentView.getSeekBar().setProgress(50);
    }

    public void bindSizeTextViewToModel() {
        getMainFragmentModel().getSize().observe((LifecycleOwner) mainFragmentView, (value) -> mainFragmentView.getSizeTextView().setText(Integer.toString(value)));
    }

    @Override
    public void bindRadioGroup() {
        mainFragmentView.getRadioGroup().setOnCheckedChangeListener((radioGroup, radioButtonId) -> {
            switch(radioButtonId) {
                case R.id.randomRadioButton:
                    mainFragmentModel.setInitilizationType(RANDOM);
                    break;
                case R.id.descendingRadioButton:
                    mainFragmentModel.setInitilizationType(DESCENDING);
                    break;
                case R.id.ascendingRadioButton:
                    mainFragmentModel.setInitilizationType(ASCENDING);
                    break;
            }
        });
        mainFragmentView.getRadioGroup().check(R.id.randomRadioButton);
    }

    @Override
    public void bindContinueButton() {
        mainFragmentView.getContinueButton().setOnClickListener(view -> {
            if (getMainFragmentModel().getSize().getValue()>2) {
                mainActivityView.showSortFragment();
            } else {
                mainFragmentView.showSizeError();
            }
        });
    }

    private void initializeMainFragmentView() {
        bindSizeTextViewToModel();
        bindSeekBarChangeToModel();
        bindRadioGroup();
        bindContinueButton();
    }


    @Override
    public void setMainActivityView(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }
}
