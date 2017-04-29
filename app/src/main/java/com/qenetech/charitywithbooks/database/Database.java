package com.qenetech.charitywithbooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.qenetech.charitywithbooks.database.cursorWrapper.UserCursorWrapper;
import com.qenetech.charitywithbooks.database.schema.*;
import com.qenetech.charitywithbooks.model.User;
import com.qenetech.charitywithbooks.utils.Utils;

/**
 * Created by davescof on 4/28/17.
 */

public class Database {
    public static final String DATABASE_NAME = "db_help_kids_read";
    public static final int DATABASE_VERSION = 1;

    private static DatabaseHelper instance;

    private Database ()
    {
        // Empty Private Constructor to enforce Singleton use
    }

    // Initialize the DatabaseHelper instance if not initialized
    public static void initialize(Context context) {
        // Check if the instance is null
        if (instance == null) {
            instance = new DatabaseHelper(context, DATABASE_NAME, DATABASE_VERSION);
        }
    }

    public static DatabaseHelper getInstance() {
        checkInit();
        return instance;
    }

    // Checks to see if the instance has been initialize
    private static void checkInit() {
        if (instance == null) {
            throw new RuntimeException("DatabaseHelper instance has not been initialized!");
        }
    }

    public static class DatabaseHelper extends SQLiteOpenHelper {

        private SQLiteDatabase mDatabase;

        public DatabaseHelper(Context context, String name, int version) {
            super(context, name, null, version);
            mDatabase = getWritableDatabase();
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            d("< ----- onCreate(SQLiteDatabase) ----- >");

            String sql;
            // Create Books table
            d("< ----- Creating Books Table ------- >");
            sql = BookTable.CREATE;
            d("Executing query: " + sql);
            db.execSQL(sql);

            // Create users table
            d("< ----- Creating Users Table ------- >");
            sql = UserTable.CREATE;
            d("Executing query: " + sql);
            db.execSQL(sql);

            // Create weather table
//            d("< ----- Creating Weather Table ------- >");
//            sql = WeatherTable.CREATE;
//            d("Executing query: " + sql);
//            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }


        public boolean createUser(String fullName, String phone, String password) {
            d("Creating new user...");
            // Create instance of the User class
            User user = new User();
            user.setFullName(fullName);
            user.setPassword(password);
            user.setPhone(phone);

            // Create ContentValues for holding the data
            ContentValues values = UserTable.getContentValues(user);

            // Insert data into database
            long rowId = mDatabase.insert(UserTable.NAME, null, values);
            boolean inserted = rowId != -1;
            if (inserted) {
                d("-> User created");
            } else {
                d("-> User not created: " + rowId);
            }
            // Return result
            return inserted;
        }

        public User getUser() {
            d("Retrieving user...");
            // Retrieve instance of the SQLiteDatabase class

            UserCursorWrapper cursor = new UserCursorWrapper(queryDatabase(UserTable.NAME, null, null));
            try {
                if (cursor.getCount() == 0) {
                    return null;
                }
                cursor.moveToFirst();
                return cursor.getUser();

            } finally {
                cursor.close();
            }
        }

        public Cursor queryDatabase (String tableName, String whereClause, String[] whereArgs) {
            Cursor cursor = mDatabase.query (
                    tableName,
                    null,
                    whereClause,
                    whereArgs,
                    null,
                    null,
                    null
            );
            return cursor;
        }

        public void signOut() {
            // Delete any logged in users inside the database

            // prepare query for deleting all users
            String sql = "DELETE * FROM " + UserTable.NAME;
            int rowsDeleted = mDatabase.delete(UserTable.NAME, "1", null);
            d("Users deleted/killed: " + rowsDeleted);
        }

        private void d(String message) {
            Utils.d(this, message);
        }
    }
}
