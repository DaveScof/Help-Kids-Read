package com.qenetech.charitywithbooks.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by davescof on 4/29/17.
 */

public class User {
    private String mId;
    private String mFullName;
    private String mPassword;
    private String mPhone;

    // Collections
    private List<Badge> mBadges = new ArrayList<>();
    private List<Kid> mKids = new ArrayList<>();
    private List<Book> mBooks = new ArrayList<>();
    private List<Question> mQuestions = new ArrayList<>();

    public User (){
        this (UUID.randomUUID().toString());
    }

    public User (String id){
        mId = id;
    }

    public String getId() {
        return mId;
    }

    public String getFullName() {
        return mFullName;
    }

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public String getPassword() {
        return mPassword;
    }

    public void setPassword(String password) {
        mPassword = password;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String phone) {
        mPhone = phone;
    }

    public void addBadge (Badge badge){
        mBadges.add(badge);
    }

    public List<Badge> getBadges() {
        return mBadges;
    }

    public void addKid (Kid kid){
        mKids.add(kid);
    }

    public List<Kid> getKids() {
        return mKids;
    }

    public void addBook (Book book){
        mBooks.add(book);
    }
    public List<Book> getBooks() {
        return mBooks;
    }

    public void addQuestion (Question question){
        mQuestions.add(question);
    }

    public List<Question> getQuestions() {
        return mQuestions;
    }
}
