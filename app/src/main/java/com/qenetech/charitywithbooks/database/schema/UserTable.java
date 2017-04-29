package com.qenetech.charitywithbooks.database.schema;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.CursorWrapper;

import com.qenetech.charitywithbooks.model.User;

/**
 * Created by davescof on 4/29/17.
 */

public class UserTable {
    public static final String NAME = "user";

    public static final String CREATE = String.format ("CREATE TABLE " + NAME + "(" +
            Cols.ID + " TEXT NOT NULL, " +
            Cols.FULL_NAME + " TEXT NOT NULL, " +
            Cols.PHONE + " TEXT NOT NULL, " +
            Cols.PASSWORD + " TEXT NOT NULL " +
            ")"
    );

    public static final class Cols {
        public static final String ID = "id";
        public static final String FULL_NAME = "full_name";
        public static final String PHONE = "phone";
        public static final String PASSWORD = "password";
    }

    public static ContentValues getContentValues (User user){
        ContentValues values = new ContentValues();
        values.put(Cols.ID, user.getId());
        values.put(Cols.FULL_NAME, user.getFullName());
        values.put(Cols.PHONE, user.getPhone());
        values.put(Cols.PASSWORD, user.getPassword());
        return values;
    }
}
