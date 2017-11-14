package com.div.sortappjava.ui.viewmodel;

import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CheckedTextView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.SearchObject;
import com.div.sortappjava.ui.activities.interfaces.MainActivityView;
import com.div.sortappjava.ui.fragments.interfaces.MainFragmentView;
import com.div.sortappjava.ui.fragments.interfaces.SortTypeFragmentView;
import com.div.sortappjava.ui.model.MainFragmentModelImpl;
import com.div.sortappjava.ui.model.SortTypeFragmentModelImpl;
import com.div.sortappjava.ui.model.interfaces.MainFragmentModel;
import com.div.sortappjava.ui.model.interfaces.SortTypeFragmentModel;
import com.div.sortappjava.ui.viewmodel.interfaces.MainActivityViewModel;
import com.div.sortappjava.ui.viewmodel.interfaces.MainFragmentViewModel;
import com.div.sortappjava.ui.viewmodel.interfaces.SortTypeFragmentViewModel;
import com.div.sortappjava.utils.enums.SortTypeEnum;

import static com.div.sortappjava.utils.Constants.DataGenerator.ASCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.DESCENDING;
import static com.div.sortappjava.utils.Constants.DataGenerator.RANDOM;

/**
 * Created by arioch666 on 11/13/17.
 */

public class MainActivityViewModelImpl extends ViewModel implements MainActivityViewModel, MainFragmentViewModel, SortTypeFragmentViewModel {
    private MainFragmentModel mainFragmentModel;
    private MainFragmentView mainFragmentView;

    private MainActivityView mainActivityView;

    private SortTypeFragmentView sortTypeFragmentView;
    private SortTypeFragmentModel sortTypeFragmentModel;

    /**
     * Main Activity
     *
     */
    @Override
    public void setMainActivityView(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
    }

    /**
     * MainFragment
     *
     */
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
                mainActivityView.showSelectAlgorithmsFragment();
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


    /**
     * SortTypeFragment
     *
     */


    public SortTypeFragmentModel getSortTypeFragmentModel() {
        if (sortTypeFragmentModel == null) {
            sortTypeFragmentModel = new SortTypeFragmentModelImpl();
        }

        return sortTypeFragmentModel;
    }

    public void setSortTypeFragmentModel(SortTypeFragmentModel sortTypeFragmentModel) {
        this.sortTypeFragmentModel = sortTypeFragmentModel;
    }

    @Override
    public void setSortTypeFragmentView(SortTypeFragmentView sortTypeFragmentView) {
        this.sortTypeFragmentView = sortTypeFragmentView;
        initializeSortTypeFragmentView();
    }

    private void initializeSortTypeFragmentView() {
        bindSortTypeContinueButton();
        bindSortTypeRecyclerView();
    }


    @Override
    public void bindSortTypeRecyclerView() {
        RecyclerView.Adapter adapter = new RecyclerView.Adapter() {
            SortTypeEnum[] sortTypeEnums = SortTypeEnum.values();

            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_types_list_item, parent, false);
                return new RecyclerView.ViewHolder(view) {
                };
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                CheckedTextView checkedTextView = (CheckedTextView) holder.itemView;
                checkedTextView.setText(sortTypeEnums[position].getStringResId());
                checkedTextView.setOnClickListener(view -> {
                    CheckedTextView checkedTextView1 = (CheckedTextView) view;
                    checkedTextView1.setChecked(!checkedTextView1.isChecked());
                    if (checkedTextView1.isChecked()) {
                        getSortTypeFragmentModel().addSortType(sortTypeEnums[position].getValue());
                    } else {
                        getSortTypeFragmentModel().addSortType(sortTypeEnums[position].getValue());
                    }
                });
            }

            @Override
            public int getItemCount() {
                return sortTypeEnums.length;
            }
        };

        sortTypeFragmentView.getSortTypeRecyclerView().setAdapter(adapter);
    }

    @Override
    public void bindSortTypeContinueButton() {
        sortTypeFragmentView.getContinueButton().setOnClickListener((view) -> {
            if(getSortTypeFragmentModel().getSortType().size() > 0) {
                mainActivityView.showSortFragment();
            } else {
                sortTypeFragmentView.showNoneSelectedError();
            }
        });
    }


}
