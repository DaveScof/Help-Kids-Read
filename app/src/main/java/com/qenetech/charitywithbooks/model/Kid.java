package com.qenetech.charitywithbooks.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davescof on 4/29/17.
 */

public class Kid {
    private String mName;
    private String mDateOfBirth;
    private String mSchool;
    private String mGrade;

    private String mProfilePictureId;

    private List<Book> mBooksRead = new ArrayList<>();
    private List<Book> mBooksReading = new ArrayList<>();
    private List<Badge> mBadges = new ArrayList<>();
}
