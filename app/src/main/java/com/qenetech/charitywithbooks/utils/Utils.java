package com.qenetech.charitywithbooks.utils;

import android.util.Log;

/**
 * Created by davescof on 4/28/17.
 */

public class Utils {
    private static final String TAG = "CharityWithBooks";

    public static void d(Object source, String message) {
        String name = source.getClass().getSimpleName();
        String output = name + " : " + message;
        Log.d(TAG, output);
    }
    public static void d(String source, String message) {
        String output = source + " : " + message;
        Log.d(TAG, output);
    }
    public static void e(Object source, String message) {
        String name = source.getClass().getSimpleName();
        String output = name + " : " + message;
        Log.e(TAG, output);
    }
    public static void e(String source, String message) {
        String output = source + " : " + message;
        Log.e(TAG, output);
    }
}
