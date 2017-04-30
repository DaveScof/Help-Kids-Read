package com.qenetech.charitywithbooks.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qenetech.charitywithbooks.R;
import com.qenetech.charitywithbooks.base.BaseScreen;


/**
 * Created by davescof on 3/15/17.
 */

public class FragmentTourQuiz extends BaseScreen {

    private String mScreenTitle = "";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.frag_tour_quiz, container, false);
        return mRoot;
    }

    @Override
    public String getTitle() {
        return mScreenTitle;
    }
}
