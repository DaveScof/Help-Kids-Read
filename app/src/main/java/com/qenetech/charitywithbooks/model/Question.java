package com.qenetech.charitywithbooks.model;

/**
 * Created by davescof on 4/29/17.
 */

public class Question {
    private static final int EASY = 0;
    private static final int MEDIUM = 0;
    private static final int HARD = 0;

    private String mBody;
    private String mAnswer;
    private String mDatePublished;
    private int mDifficulty;

    private String mVote;

    public static int getEASY() {
        return EASY;
    }

    public static int getMEDIUM() {
        return MEDIUM;
    }

    public static int getHARD() {
        return HARD;
    }

    public String getBody() {
        return mBody;
    }

    public void setBody(String body) {
        mBody = body;
    }

    public String getAnswer() {
        return mAnswer;
    }

    public void setAnswer(String answer) {
        mAnswer = answer;
    }

    public String getDatePublished() {
        return mDatePublished;
    }

    public void setDatePublished(String datePublished) {
        mDatePublished = datePublished;
    }

    public int getDifficulty() {
        return mDifficulty;
    }

    public void setDifficulty(int difficulty) {
        mDifficulty = difficulty;
    }

    public String getVote() {
        return mVote;
    }

    public void setVote(String vote) {
        mVote = vote;
    }
}
