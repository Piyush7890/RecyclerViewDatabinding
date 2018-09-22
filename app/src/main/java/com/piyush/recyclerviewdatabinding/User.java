package com.piyush.recyclerviewdatabinding;

public class User {

    private String gender;
    private String name;

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    private String imageUrl;

    public User(String gender, String name, String imageUrl) {
        this.gender = gender;
        this.name = name;
        this.imageUrl = imageUrl;
    }
}
