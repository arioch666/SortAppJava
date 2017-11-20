package com.div.sortappjava.ui.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.ViewModel;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.div.sortappjava.R;
import com.div.sortappjava.datagenerator.datagenerators.IntegerDataGeneratorSingleton;
import com.div.sortappjava.datagenerator.interfaces.DataGenerator;
import com.div.sortappjava.sort.InsertionSort;
import com.div.sortappjava.sort.QuickSort;
import com.div.sortappjava.sort.SelectionSort;
import com.div.sortappjava.sort.Sorter;
import com.div.sortappjava.ui.SortObject;
import com.div.sortappjava.ui.fragments.interfaces.SortFragmentView;
import com.div.sortappjava.ui.model.SortFragmentModelImpl;
import com.div.sortappjava.ui.model.interfaces.SortFragmentModel;
import com.div.sortappjava.ui.view.SortObjectVisualizer;
import com.div.sortappjava.ui.viewmodel.interfaces.SortFragmentViewModel;
import com.div.sortappjava.utils.enums.SortTypeEnum;

import java.util.Arrays;
import java.util.List;

/**
 * Created by arioch666 on 11/14/17.
 */

public class SortFragmentViewModelImpl extends ViewModel implements SortFragmentViewModel {

    private SortFragmentView sortFragmentView;
    private SortFragmentModel sortFragmentModel;

    private DataGenerator dataGenerator;

    private RecyclerView.Adapter adapter;

    @Override
    public SortFragmentModel getSortFragmentModel() {
        if (sortFragmentModel == null) {
            sortFragmentModel = new SortFragmentModelImpl();
        }

        return sortFragmentModel;
    }

    @Override
    public void setSortFragmentView(SortFragmentView sortFragmentView) {
        this.sortFragmentView = sortFragmentView;
        initializaSortFragmentView();
    }

    private void initializaSortFragmentView() {
        initializeSearchObjects();
        bindBeginSortButton();
        bindRecyclerView();
    }

    private void initializeSearchObjects() {
        List<Integer> sortTypeList = sortFragmentView.getSortTypeList();
        SortObject[] sortObjects = new SortObject[sortTypeList.size()];

        for(int i = 0; i < sortObjects.length; i++) {
            SortObject<Integer> integerSortObject = new SortObject<>();
            integerSortObject.setValues(Arrays.copyOf((Integer[]) getDataGenerator().getData(), getDataGenerator().getSize()));
            integerSortObject.setMaxValue((Integer) getDataGenerator().getMaxValue());
            integerSortObject.setSorter(getSorter(sortTypeList.get(i)));

            sortObjects[i] = integerSortObject;

            integerSortObject.getValues().observe((LifecycleOwner) sortFragmentView, integers -> {
                updateUI();
            });

            integerSortObject.getHighlightIndices().observe((LifecycleOwner) sortFragmentView, integers -> {
                updateUI();
            });

            integerSortObject.getRange().observe((LifecycleOwner) sortFragmentView, integers -> {
                updateUI();
            });

            integerSortObject.getSorted().observe((LifecycleOwner) sortFragmentView, aBoolean -> updateUI());
        }

        getSortFragmentModel().setData(sortObjects);
    }

    private void updateUI() {
        if (adapter != null) {
            adapter.notifyDataSetChanged();
        }
    }

    private Sorter<Integer> getSorter(Integer integer) {
        SortTypeEnum sortTypeEnum = SortTypeEnum.enumFromValue(integer);

        switch(sortTypeEnum) {
            case INSERTION_SORT:
                return new InsertionSort();
//            case MERGE_SORT:
//                return new MergeSort();
            case QUICK_SORT:
                return new QuickSort();
            case SELECTION_SORT:
                return new SelectionSort();
        }
        return new QuickSort();
    }

    @Override
    public void bindRecyclerView() {
        adapter = new RecyclerView.Adapter() {

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_fragment_list_item, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                View itemView = holder.itemView;

                SortObject sortObject = getSortFragmentModel().getData()[position];

                TextView textView = itemView.findViewById(R.id.sortTypeName);

                textView.setText(sortObject.getSorter().getSortTypeEnum().getStringResId());

                SortObjectVisualizer sortObjectVisualizer = itemView.findViewById(R.id.sortObjectVisualizer);
                sortObjectVisualizer.setSortObject(sortObject);
            }

            @Override
            public int getItemCount() {
                return getSortFragmentModel().getData().length;
            }

        };

        sortFragmentView.getRecyclerView().setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }



    private void beginSort() {
        SortObject[] sortObjects = getSortFragmentModel().getData();
        Runnable[] runnables = new Runnable[sortObjects.length];

        for (int i = 0; i < sortObjects.length; i++) {
            int finalI = i;
            runnables[i] = () -> sortObjects[finalI].startSorting();
        }

        for (Runnable runnable : runnables) {
            new Thread (runnable).start();
        }
    }

    @Override
    public void setDataGenerator(DataGenerator dataGenerator) {
        this.dataGenerator = dataGenerator;
    }

    @Override
    public void bindBeginSortButton() {
        sortFragmentView.getBeginSortButton().setOnClickListener(view -> {
            sortFragmentView.hideOverlay();
            beginSort();
        });
    }

    private DataGenerator getDataGenerator() {
        if (dataGenerator == null) {
            dataGenerator = IntegerDataGeneratorSingleton.getInstance();
        }
        return dataGenerator;
    }

}
