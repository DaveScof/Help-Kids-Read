package com.qenetech.charitywithbooks.database;

import android.content.ContentValues;

import com.qenetech.charitywithbooks.model.User;

/**
 * Created by davescof on 4/27/17.
 */

public class CharityWithBooksSchema {
    public static final class FarmTable {
        public static final String NAME = "farms";
        public static final String CREATE = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL" +
                        ")",
                NAME,
                Cols.ID,
                Cols.LOCATION,
                Cols.USER_ID
        );

        public static final class Cols {
            public static final String ID = "farm_id";
            public static final String LOCATION = "location";
            public static final String USER_ID = "user_id";
        }
    }

    public static final class UserTable {
        public static final String NAME = "users";
        public static final String CREATE = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT PRIMARY KEY," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT NOT NULL," +
                        "%s TEXT," +
                        "%s TEXT NOT NULL," +
                        "%s INTEGER NOT NULL" +
                        ")",
                NAME,
                Cols.ID,
                Cols.FIRST_NAME,
                Cols.LAST_NAME,
                Cols.EMAIL,
                Cols.PHONE,
                Cols.LOGIN_TIME
        );

        public static final class Cols {
            public static final String ID = "id";
            public static final String FIRST_NAME = "first_name";
            public static final String LAST_NAME = "last_name";
            public static final String EMAIL = "email";
            public static final String PHONE = "phone";
            public static final String LOGIN_TIME = "login_time";
        }

        public static ContentValues getContentValues (User user){
            ContentValues values = new ContentValues();
            values.put(Cols.ID, user.getID());
            values.put(Cols.FIRST_NAME, user.getFirstName());
            values.put(Cols.LAST_NAME, user.getLastName());
            values.put(Cols.EMAIL, user.getEmail());
            values.put(Cols.PHONE, user.getPhone());
            values.put(Cols.LOGIN_TIME, user.getLogInTime().getTime());

            return values;
        }
    }

    public static final class WeatherTable {
        public static final String NAME = "weather";
        public static final String CREATE = String.format(
                "CREATE TABLE IF NOT EXISTS %s (" +
                        "%s TEXT PRIMARY KEY," +
                        "%s INTEGER NOT NULL," +
                        "%s INTEGER NOT NULL" +
                        ")",
                NAME,
                Cols.ID,
                Cols.TIME,
                Cols.SUMMARY
        );

        public static final class Cols {
            public static final String ID = "id";
            public static final String TIME = "time";
            public static final String SUMMARY = "summary";
            public static final String ICON = "icon";
            public static final String TEMPERATURE = "temperature";
            public static final String HUMIDITY = "humidity";
            public static final String WIND_SPEED = "wind_speed";
            public static final String WIND_BEARING = "wind_bearing";
            public static final String PRESSURE = "pressure";
            public static final String DEW_POINT = "dew_point";
            public static final String CLOUD_COVER = "cloud_cover";
            public static final String PRECIPITATION_INTENSITY = "precipitation_intensitiy";
            public static final String PRECIPITATION_PROBABILITY = "precipitation_probability";
        }
    }
}
