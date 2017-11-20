package com.div.sortappjava.ui.fragments.fragments;


import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.fragments.interfaces.MainFragmentView;
import com.div.sortappjava.ui.viewmodel.MainActivityViewModelImpl;
import com.div.sortappjava.ui.viewmodel.interfaces.MainFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainFragmentView {

    SeekBar seekBar;
    RecyclerView sortTypeRecyclerView;
    TextView sizeTextView;
    Button continueButton;
    RadioGroup radioGroup;

    MainFragmentViewModel mainFragmentViewModel;

    public static Fragment newInstance() {
        return new MainFragment();
    }


    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        seekBar = view.findViewById(R.id.seekBar);
        sizeTextView = view.findViewById(R.id.nValueText);
        continueButton = view.findViewById(R.id.mainFragmentContinueButton);
        radioGroup = view.findViewById(R.id.radioGroup);
        sortTypeRecyclerView = view.findViewById(R.id.selectAlgorithmRecyclerView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //This is the same viewmodel that is in the activity, the context given is of the activity.
        mainFragmentViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModelImpl.class);
        mainFragmentViewModel.setMainFragmentView(this);
    }

    @Override
    public SeekBar getSeekBar() {
        return seekBar;
    }

    @Override
    public Button getContinueButton() {
        return continueButton;
    }

    @Override
    public TextView getSizeTextView() {
        return sizeTextView;
    }

    @Override
    public RadioGroup getRadioGroup() {
        return radioGroup;
    }

    @Override
    public void showSizeError() {
        Toast.makeText(getActivity(), "Please Select a size that is greater than 2", Toast.LENGTH_SHORT).show();
    }
}
