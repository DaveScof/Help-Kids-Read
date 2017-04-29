package com.qenetech.charitywithbooks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.qenetech.charitywithbooks.R;
import com.qenetech.charitywithbooks.base.BasePagerActivity;
import com.qenetech.charitywithbooks.fragment.FragmentTourBooks;
import com.qenetech.charitywithbooks.fragment.FragmentTourKids;
import com.qenetech.charitywithbooks.fragment.FragmentTourQuiz;


/**
 * Created by davescof on 3/14/17.
 */

public class TourActivity extends BasePagerActivity {

    private Button mNextButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tour);
        setupViewpager();

        mNextButton = (Button) findViewById(R.id.tourNextButton);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentScreen = mViewPager.getCurrentItem();
                if (currentScreen <2)
                    mViewPager.setCurrentItem(currentScreen+1);
                else
                {
                    Intent intent = new Intent(TourActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }

    private void setupViewpager (){
        mViewPager = getVp(R.id.single_view_pager);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tablayout);
        tabLayout.setupWithViewPager(mViewPager);
        final Fragment[] fragments = {new FragmentTourKids(), new FragmentTourBooks(), new FragmentTourQuiz()};

        addFragments(fragments);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (mViewPager.getCurrentItem() == 2)
                    mNextButton.setText(R.string.join);
                else
                    mNextButton.setText(R.string.next);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        int currentScreen = mViewPager.getCurrentItem();
        if(currentScreen > 0) {
            mViewPager.setCurrentItem(currentScreen - 1);
        }
        else
            super.onBackPressed();
    }
}
