package com.div.sortappjava.ui.model;

import android.arch.lifecycle.MutableLiveData;

import com.div.sortappjava.ui.model.interfaces.MainFragmentModel;

import java.util.HashSet;
import java.util.Set;

import static com.div.sortappjava.utils.Constants.DataGenerator.RANDOM;

/**
 * Created by arioch666 on 11/13/17.
 *
 * Model for the main fragment
 *
 *
 */

public class MainFragmentModelImpl implements MainFragmentModel {

    MutableLiveData<Integer> size = new MutableLiveData<>();
    Integer initializationType;

    Set<Integer> sortAlgorithmsToUse = new HashSet<>();

    public MainFragmentModelImpl(MutableLiveData<Integer> size, Integer initializationType, Set<Integer> sortAlgorithmsToUse) {
        this.size = size;
        this.initializationType = initializationType;
        this.sortAlgorithmsToUse = sortAlgorithmsToUse;
    }

    public MainFragmentModelImpl() {
        this.size.setValue(50);
        this.initializationType = RANDOM;
    }

    @Override
    public void setSize(int size) {
        this.size.setValue(size);
    }

    @Override
    public void setInitilizationType(int initializationType) {
        this.initializationType = initializationType;
    }

    @Override
    public MutableLiveData<Integer> getSize() {
        return size;
    }

    @Override
    public Integer getInitializationType() {
        return initializationType;
    }

}
