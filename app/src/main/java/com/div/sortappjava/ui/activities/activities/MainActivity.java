package com.div.sortappjava.ui.activities.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.activities.interfaces.MainActivityView;
import com.div.sortappjava.ui.fragments.fragments.MainFragment;
import com.div.sortappjava.ui.fragments.fragments.SortTypeFragment;
import com.div.sortappjava.ui.viewmodel.MainActivityViewModelImpl;
import com.div.sortappjava.ui.viewmodel.interfaces.MainActivityViewModel;

/**
 * Just the primary life cycle for the activity,
 * Most of the business logic is in the {@link MainActivityViewModelImpl}
 *
 */
public class MainActivity extends AppCompatActivity implements MainActivityView {

    MainActivityViewModel mainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModelImpl.class);

        mainActivityViewModel.setMainActivityView(this);

        initializeMainFragment();
    }

    private void initializeMainFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, MainFragment.newInstance())
                .commit();
    }


    @Override
    public void showSortActivity() {
        startActivity(SortActivity.newIntent(this, mainActivityViewModel.getSortTypeList()));
    }

    @Override
    public void showSelectAlgorithmsFragment() {
        getSupportFragmentManager().beginTransaction()
                .addToBackStack(SortTypeFragment.class.getCanonicalName())
                .replace(R.id.fragment_container, SortTypeFragment.newInstance())
                .commit();
    }


    @Override
    protected void onStop() {
        super.onStop();
    }
}
