package com.example.demo.models;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "Posts")
public class PostMongoDB {
    @Id
    private int id;

    private String content;

    @DBRef(lazy = true)
    private UserMongoDB poster;

    @DBRef(lazy = true)
    private List<LikeMongoDB> likes;

    @DBRef(lazy = true)
    private List<CommentMongoDB> comments;

    private Date createdAt = new Date(System.currentTimeMillis() + 7 * 3600 * 1000);

    public PostMongoDB() {
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

    public UserMongoDB getPoster() {
        return poster;
    }

    public void setPoster(UserMongoDB poster) {
        this.poster = poster;
    }

    public List<LikeMongoDB> getLikes() {
        return likes;
    }

    public void setLikes(List<LikeMongoDB> likes) {
        this.likes = likes;
    }

    public List<CommentMongoDB> getComments() {
        return comments;
    }

    public void setComments(List<CommentMongoDB> comments) {
        this.comments = comments;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
