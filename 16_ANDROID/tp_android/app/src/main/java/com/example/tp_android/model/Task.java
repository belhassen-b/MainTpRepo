package com.example.tp_android.model;


import java.io.Serializable;


public class Task implements Serializable {
    private String title;

    public Task(String taskTitle) {
        this.title = taskTitle;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
