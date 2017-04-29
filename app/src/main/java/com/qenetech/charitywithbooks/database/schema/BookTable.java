package com.qenetech.charitywithbooks.database.schema;

/**
 * Created by davescof on 4/29/17.
 */

public class BookTable {
    public static final String NAME = "books";

    public static final String CREATE = String.format ("CREATE TABLE " + NAME + "(" +
            Cols.ID + " TEXT NOT NULL, " +
            Cols.TITLE + ", " +
            Cols.AUTHOR + ", " +
            Cols.DESCRIPTION + ", " +
            Cols.PUBLISHED + ", " +
            Cols.ICON + ", " +
            Cols.GRADE_LEVEL +
            ")"
    );

    public static final class Cols {
        public static final String ID = "book_id";
        public static final String TITLE = "title";
        public static final String AUTHOR = "author";
        public static final String DESCRIPTION = "description";
        public static final String PUBLISHED = "published";
        public static final String ICON = "icon";
        public static final String GRADE_LEVEL = "grade_level";
    }
}
