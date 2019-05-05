package com.example.etnateraapp.model;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;

@Entity(tableName = "sports")
public class SportResult implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String name;
    private String place;
    private int time;
    private boolean localStorage;
    private boolean externalStorage;


    public SportResult() {
    }

    public SportResult(String name, String place, int time) {
        this.name = name;
        this.place = place;
        this.time = time;
        this.localStorage = false;
        this.externalStorage = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public boolean getLocalStorage() {
        return localStorage;
    }

    public void setLocalStorage(boolean localStorage) {
        this.localStorage = localStorage;
    }

    public boolean getExternalStorage() {
        return externalStorage;
    }

    public void setExternalStorage(boolean externalStorage) {
        this.externalStorage = externalStorage;
    }
}
