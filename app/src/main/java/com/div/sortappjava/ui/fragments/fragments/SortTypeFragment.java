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
import android.widget.Toast;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.fragments.interfaces.SortTypeFragmentView;
import com.div.sortappjava.ui.viewmodel.MainActivityViewModelImpl;
import com.div.sortappjava.ui.viewmodel.interfaces.SortTypeFragmentViewModel;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SortTypeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SortTypeFragment extends Fragment implements SortTypeFragmentView {

    SortTypeFragmentViewModel sortTypeViewModel;
    private Button continueButton;
    private RecyclerView sortTypeRecyclerView;

    public SortTypeFragment() {
        // Required empty public constructor
    }

    public static SortTypeFragment newInstance() {
        return new SortTypeFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sort_type, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //Shared View Model
        sortTypeViewModel = ViewModelProviders.of(getActivity()).get(MainActivityViewModelImpl.class);
        sortTypeViewModel.setSortTypeFragmentView(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        continueButton = view.findViewById(R.id.sortTypeFragmentContinueButton);
        sortTypeRecyclerView = view.findViewById(R.id.sortTypeRecyclerView);
    }

    @Override
    public Button getContinueButton() {
        return continueButton;
    }

    @Override
    public RecyclerView getSortTypeRecyclerView() {
        return sortTypeRecyclerView;
    }

    @Override
    public void showNoneSelectedError() {
        Toast.makeText(getActivity(), R.string.select_algorithm_error, Toast.LENGTH_SHORT).show();
    }
}
