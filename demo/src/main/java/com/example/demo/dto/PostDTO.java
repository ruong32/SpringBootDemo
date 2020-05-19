package com.example.demo.dto;

import java.util.Date;
import java.util.List;

public class PostDTO {
    private int id;
    private String content;
    private UserDTO poster;
    private List<LikeDTO> likes;
    private List<CommentDTO> comments;
    private Date createdAt;

    public PostDTO() {
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

    public UserDTO getPoster() {
        return poster;
    }

    public void setPoster(UserDTO poster) {
        this.poster = poster;
    }

    public List<LikeDTO> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeDTO> likes) {
        this.likes = likes;
    }

    public List<CommentDTO> getComments() {
        return comments;
    }

    public void setComments(List<CommentDTO> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
