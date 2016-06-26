package com.example.newrairai;

import android.graphics.Bitmap;
import android.support.annotation.DrawableRes;

import java.io.Serializable;

/**
 * Created by 聡一朗 on 2016/06/26.
 */
public class User implements Serializable {
    private @DrawableRes  int icon;
    private String name;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    private String loc;
}