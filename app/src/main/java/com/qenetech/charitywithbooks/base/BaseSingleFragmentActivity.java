package com.qenetech.charitywithbooks.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by gebeya-admin on 1/23/17.
 */

public abstract class BaseSingleFragmentActivity extends AppCompatActivity {

    public int mFragmentLayout;
    public int mFragmentContainer;

    public abstract Fragment createFragment ();
    public abstract void init(int fragmentLayout, int fragmentContainer);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(mFragmentLayout);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(mFragmentContainer);

        if (fragment == null){
            fragment = createFragment();
            fragmentManager.beginTransaction().add(mFragmentContainer, fragment).commit();
        }
    }
}
