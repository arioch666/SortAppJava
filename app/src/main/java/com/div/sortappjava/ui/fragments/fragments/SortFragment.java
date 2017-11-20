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
import android.widget.FrameLayout;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.fragments.interfaces.SortFragmentView;
import com.div.sortappjava.ui.viewmodel.SortFragmentViewModelImpl;
import com.div.sortappjava.ui.viewmodel.interfaces.SortFragmentViewModel;
import com.div.sortappjava.utils.Constants;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SortFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SortFragment extends Fragment implements SortFragmentView {

    private RecyclerView recyclerView;
    private FrameLayout sortOverlay;
    private Button beginSortButton;

    private SortFragmentViewModel sortFragmentViewModel;

    public SortFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment SortFragment.
     */
    public static SortFragment newInstance(ArrayList<Integer> sortTypeList) {
        SortFragment sortFragment = new SortFragment();
        Bundle bundle = new Bundle();
        bundle.putIntegerArrayList(Constants.Activities.SORT_TYPE_LIST, sortTypeList);
        sortFragment.setArguments(bundle);
        return sortFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sortFragmentViewModel = ViewModelProviders.of(this).get(SortFragmentViewModelImpl.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sort, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.sortFragmentRecyclerView);
        sortOverlay = view.findViewById(R.id.sortOverlay);
        beginSortButton = view.findViewById(R.id.beginSortButton);
    }

    @Override
    public void onResume() {
        super.onResume();
        sortFragmentViewModel.setSortFragmentView(this);
    }

    @Override
    public RecyclerView getRecyclerView() {
        return recyclerView;
    }

    @Override
    public List<Integer> getSortTypeList() {
        return getArguments().getIntegerArrayList(Constants.Activities.SORT_TYPE_LIST);
    }

    @Override
    public FrameLayout getSortOverlay() {
        return sortOverlay;
    }

    @Override
    public Button getBeginSortButton() {
        return beginSortButton;
    }
}
