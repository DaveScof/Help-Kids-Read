package com.qenetech.charitywithbooks.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


import com.qenetech.charitywithbooks.utils.Utils;

import java.util.Date;

/**
 * Created by davescof on 4/28/17.
 */

public class Database {
    public static final String DATABASE_NAME = "db_waziup_agriculture";
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

        public DatabaseHelper(Context context, String name, int version) {
            super(context, name, null, version);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            d("< ----- onCreate(SQLiteDatabase) ----- >");

//            String sql;
//            // Create farms table
//            d("< ----- Creating Farm Table ------- >");
//            sql = FarmTable.CREATE;
//            d("Executing query: " + sql);
//            db.execSQL(sql);
//
//            // Create users table
//            d("< ----- Creating Users Table ------- >");
//            sql = UserTable.CREATE;
//            d("Executing query: " + sql);
//            db.execSQL(sql);
//
//            // Create weather table
//            d("< ----- Creating Weather Table ------- >");
//            sql = WeatherTable.CREATE;
//            d("Executing query: " + sql);
//            db.execSQL(sql);
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        }


//        public boolean createUser(String firstName, String lastName, String email, String phone) {
//            d("Creating new user...");
//            // Create instance of the User class
//            User user = new User();
//            user.setFirstName(firstName);
//            user.setLastName(lastName);
//            user.setEmail(email);
//            user.setPhone(phone);
//
//            // Retrieve instance of the SQLiteDatabase class
//            SQLiteDatabase db = getWritableDatabase();
//
//            // Create ContentValues for holding the data
//            ContentValues values = UserTable.getContentValues(user);
//
//            // Insert data into database
//            long rowId = db.insert(UserTable.NAME, null, values);
//            boolean inserted = rowId != -1;
//            if (inserted) {
//                d("-> User created");
//            } else {
//                d("-> User not created: " + rowId);
//            }
//            // Return result
//            return inserted;
//        }
//
//        public User getUser() {
//            d("Retrieving user...");
//            // Retrieve instance of the SQLiteDatabase class
//            SQLiteDatabase db = getWritableDatabase();
//            String sql = "SELECT * FROM " + UserTable.NAME;
//            Cursor cursor = db.rawQuery(sql, null);
//
//            // Use the cursor to navigate the rows of data
//            if (cursor != null) {
//                // Try to move to the first row
//                boolean canMove = cursor.moveToFirst();
//                if (canMove) {
//                    // Create instance of the user
//                    User user = new User(cursor.getString(0));
//                    user.setEmail(cursor.getString(1));
//                    user.setPhone(cursor.getString(2));
//                    user.setLogInTime(new Date(cursor.getLong(3)));
//                    // close the cursor
//                    cursor.close();
//                    // return the User
//                    return user;
//                }
//            }
//            return null;
//        }
//
//        public void signOut() {
//            // Delete any logged in users inside the database
//            // get the db
//            SQLiteDatabase db = getWritableDatabase();
//            // prepare query for deleting all users
//            String sql = "DELETE * FROM " + UserTable.NAME;
//            int rowsDeleted = db.delete(UserTable.NAME, "1", null);
//            d("Users deleted/killed: " + rowsDeleted);
//        }

        private void d(String message) {
            Utils.d(this, message);
        }
    }
}
