package com.qenetech.charitywithbooks.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Button;


/**
 * Created by dave-5cof on 1/29/17.
 */

public abstract class BasePagerActivity extends BaseActivity {
    public ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public ViewPager getVp (int id) {
        return  (ViewPager) findViewById(id);
    }

    public boolean addFragments(final Fragment... fragments){
        if (mViewPager == null)
            return false;

        mViewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments[position];
            }

            @Override
            public int getCount() {
                return fragments.length;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                BaseScreen fragment = (BaseScreen) fragments[position];
                return fragment.getTitle();
            }
        });

        return true;
    }

    public Button getBt(int id) {
        return (Button) findViewById(id);
    }
}
