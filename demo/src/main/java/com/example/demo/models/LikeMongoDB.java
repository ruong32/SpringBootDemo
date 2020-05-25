package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Likes")
public class LikeMongoDB {
    @Id
    private int id;

    private String type;

    @DBRef(lazy = true)
    private PostMongoDB post;

    @DBRef(lazy = true)
    private UserMongoDB user;

    public LikeMongoDB() {
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
}
