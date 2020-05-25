package com.example.demo.dto;

public class UserDTOMongoDB {
    private int id;
    private String userName;

    public UserDTOMongoDB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String name) {
        this.userName = name;
    }
}
