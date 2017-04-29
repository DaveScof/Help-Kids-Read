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

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDateOfBirth() {
        return mDateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        mDateOfBirth = dateOfBirth;
    }

    public String getSchool() {
        return mSchool;
    }

    public void setSchool(String school) {
        mSchool = school;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }

    public String getProfilePictureId() {
        return mProfilePictureId;
    }

    public void setProfilePictureId(String profilePictureId) {
        mProfilePictureId = profilePictureId;
    }

    public void addBookRead (Book book) {
        mBooksRead.add(book);
    }

    public List<Book> getBooksRead() {
        return mBooksRead;
    }

    public void addBookReading (Book book){
        mBooksReading.add(book);
    }

    public List<Book> getBooksReading() {
        return mBooksReading;
    }

    public void addBadge (Badge badge){
        mBadges.add(badge);
    }

    public List<Badge> getBadges() {
        return mBadges;
    }
}
