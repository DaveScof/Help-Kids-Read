package com.qenetech.charitywithbooks.database;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by davescof on 4/7/17.
 */

public class QueryPreferences {

    private static final String PREF_APP_OPENED = "AppOpened";

    public static boolean appOened (Context context){
        return PreferenceManager.getDefaultSharedPreferences(context)
                .getBoolean(PREF_APP_OPENED, false);
    }

    public static void setAppOpened (Context context){
        PreferenceManager.getDefaultSharedPreferences(context)
                .edit()
                .putBoolean(PREF_APP_OPENED, true)
                .apply();
    }
}
