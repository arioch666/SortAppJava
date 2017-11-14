package com.div.sortappjava.ui.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.div.sortappjava.R;
import com.div.sortappjava.ui.activities.interfaces.MainActivityView;
import com.div.sortappjava.ui.fragments.MainFragment;
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
    public void showSortFragment() {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, SortFragment.newInstance())
//                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
//                .commit();
    }

    @Override
    public void showSelectAlgorithmsFragment() {
//        getSupportFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, SelectAlgorithmsFragment.newInstance())
//                .setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right)
//                .commit();
    }
}
