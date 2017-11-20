package com.div.sortappjava.ui.activities.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.activities.interfaces.SortActivityView;
import com.div.sortappjava.ui.fragments.fragments.SortFragment;
import com.div.sortappjava.utils.Constants;
import com.div.sortappjava.utils.enums.SortTypeEnum;

import java.util.ArrayList;
import java.util.List;

public class SortActivity extends AppCompatActivity implements SortActivityView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sort);

        launchSortFragment();
    }

    @Override
    public void launchSortFragment() {
        ArrayList<Integer> sortTypeList = getIntent().getIntegerArrayListExtra(Constants.Activities.SORT_TYPE_LIST);

        if (sortTypeList == null) {
            sortTypeList = new ArrayList<>();
            sortTypeList.add(SortTypeEnum.QUICK_SORT.getValue());
        }

        getSupportFragmentManager().beginTransaction()
        .replace(R.id.sortFragmentContainer, SortFragment.newInstance(sortTypeList))
        .commit();
    }

    public static Intent newIntent(Context launchingContext, ArrayList<Integer> sortTypeList) {
        Intent intent
                 = new Intent(launchingContext, SortActivity.class);
        intent.putIntegerArrayListExtra(Constants.Activities.SORT_TYPE_LIST, sortTypeList);

        return intent;
    }
}
