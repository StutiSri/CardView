package com.example.stutisrivastava.cardview.pojo;

/**
 * Created by stutisrivastava on 31/10/15.
 */
public class Person {
    String name;
    String age;
    int photoId;

    public Person(String name, String age, int photoId) {
        this.name = name;
        this.age = age;
        this.photoId = photoId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }
}
