package com.qenetech.charitywithbooks.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


import com.qenetech.charitywithbooks.App;
import com.qenetech.charitywithbooks.R;
import com.qenetech.charitywithbooks.base.BaseActivity;
import com.qenetech.charitywithbooks.database.Database;
import com.qenetech.charitywithbooks.database.QueryPreferences;

/**
 * Created by davescof on 3/13/17.
 */

public class Splash extends BaseActivity {

    private static final int SPLASH_TIME_OUT = 3000;
    private boolean mViewClicked = false;
    private boolean mAppClosed = false;
    private Database.DatabaseHelper mHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        App context = (App) getApplication();

        // Create an instance of the DatabaseHelper class
        mHelper = Database.getInstance();

        findViewById(R.id.avtivity_splash).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mViewClicked = true;
                startApplication();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!mViewClicked && !mAppClosed)
                    startApplication();
            }
        }, SPLASH_TIME_OUT);
    }

    private void startApplication (){

        // Figure out if there is already a user in the database
//        User user = mHelper.getUser();
//        if (user != null) {
//            d("A user already exists in the Database");
//            openHome();
//            return;
//        }

        boolean appHasBeenOpened = QueryPreferences.appOened(this);
        Intent nextActivity = null;

        nextActivity = new Intent(this, TourActivity.class);


//        if (appHasBeenOpened) {
//            nextActivity = new Intent(this, RegisterActivity.class);
//        }
//        else {
//            nextActivity = new Intent(this, TourActivity.class);
//            QueryPreferences.setAppOpened(this);
//        }
//
        nextActivity = new Intent(this, HomeActivity.class);
        startActivity(nextActivity);
        finish();
    }

    @Override
    public void onBackPressed() {
        mAppClosed = true;
        super.onBackPressed();
    }

    private void openHome (){
//        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
