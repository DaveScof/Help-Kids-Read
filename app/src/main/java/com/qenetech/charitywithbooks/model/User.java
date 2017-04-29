package com.qenetech.charitywithbooks.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by davescof on 4/29/17.
 */

public class User {
    private String mId;
    private String mFullName;
    private String mEmail;
    private String mPassword;
    private String mPhone;

    // Collections
    private List<Badge> mBadges = new ArrayList<>();
    private List<Kid> mKidsHelped = new ArrayList<>();
    private List<Book> mBooksAdded = new ArrayList<>();
    private List<Question> mQuestions = new ArrayList<>();


}
