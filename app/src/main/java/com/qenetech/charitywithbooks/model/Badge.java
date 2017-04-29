package com.qenetech.charitywithbooks.model;

import android.graphics.drawable.Drawable;

import java.util.UUID;

/**
 * Created by davescof on 4/29/17.
 */

public class Badge {
    private String mId;
    private String mName;
    private String mIcon;
    private String mDescription;

    public Badge (){
        this (UUID.randomUUID().toString());
    }

    public Badge (String id) {
        mId = id;
    }

    public String getId (){
        return mId;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }
}
