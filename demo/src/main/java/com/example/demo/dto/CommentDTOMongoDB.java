package com.example.demo.dto;

import java.util.Date;

public class CommentDTOMongoDB {
    private int id;
    private String content;
    private int postId;
    private UserDTOMongoDB user;
    private Date createdAt = new Date(System.currentTimeMillis() + 7 * 3600 * 1000);

    public CommentDTOMongoDB() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public UserDTOMongoDB getUser() {
        return user;
    }

    public void setUser(UserDTOMongoDB user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
