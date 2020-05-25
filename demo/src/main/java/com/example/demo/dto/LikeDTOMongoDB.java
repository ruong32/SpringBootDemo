package com.example.demo.dto;

public class LikeDTOMongoDB {
    private int id;
    private String type;
    private UserDTOMongoDB user;
    private int postId;

    public LikeDTOMongoDB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserDTOMongoDB getUser() {
        return user;
    }

    public void setUser(UserDTOMongoDB user) {
        this.user = user;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }
}
