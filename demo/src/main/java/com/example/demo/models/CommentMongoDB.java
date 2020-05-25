package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Document(collection = "Comments")
public class CommentMongoDB {
    @Id
    private int id;

    private String content;

    @DBRef(lazy = true)
    private PostMongoDB post;

    @DBRef(lazy = true)
    private UserMongoDB user;

    private Date createdAt;

    public CommentMongoDB() {
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

    public PostMongoDB getPost() {
        return post;
    }

    public void setPost(PostMongoDB post) {
        this.post = post;
    }

    public UserMongoDB getUser() {
        return user;
    }

    public void setUser(UserMongoDB user) {
        this.user = user;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
