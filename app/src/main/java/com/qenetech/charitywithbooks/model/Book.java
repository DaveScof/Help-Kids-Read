package com.qenetech.charitywithbooks.model;

/**
 * Created by davescof on 4/29/17.
 */

public class Book {
    private String mId;
    private String mTitle;
    private String mAuthor;
    private String mDescription;
    private String mPublished;
    private String mIcon;
    private String mGradeLevel;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getPublished() {
        return mPublished;
    }

    public void setPublished(String published) {
        mPublished = published;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getGradeLevel() {
        return mGradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        mGradeLevel = gradeLevel;
    }
}
