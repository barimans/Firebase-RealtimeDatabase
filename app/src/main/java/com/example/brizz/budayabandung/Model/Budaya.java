package com.example.brizz.budayabandung.Model;

/**
 * Created by brizz on 11/15/17.
 */

public class Budaya {
    private String title, image, desc;

    public Budaya(String title, String image, String desc) {
        this.title = title;
        this.image = image;
        this.desc = desc;
    }

    public Budaya(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
