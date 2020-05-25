package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class PostDTOMongDB {
    private int id;
    private String content;
    private UserDTOMongoDB poster;
    private List<LikeDTOMongoDB> likes;
    private List<CommentDTOMongoDB> comments;
    private Date createdAt = new Date(System.currentTimeMillis() + 7 * 3600 * 1000);

    public PostDTOMongDB() {
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

    public UserDTOMongoDB getPoster() {
        return poster;
    }

    public void setPoster(UserDTOMongoDB poster) {
        this.poster = poster;
    }

    public List<LikeDTOMongoDB> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDTOMongoDB> likes) {
        this.likes = likes;
    }

    public List<CommentDTOMongoDB> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTOMongoDB> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
