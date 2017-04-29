package com.qenetech.charitywithbooks;

import android.app.Application;

import com.qenetech.charitywithbooks.database.Database;
import com.qenetech.charitywithbooks.utils.Utils;

/**
 * Created by davescof on 4/28/17.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.e(this, "< ---------------------------------------- Application.onCreate() ---------------------------------------- >");
        Database.initialize(this);
    }
}
