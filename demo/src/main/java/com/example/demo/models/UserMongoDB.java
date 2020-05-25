package com.example.demo.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Users")
public class UserMongoDB {
    @Id
    private int id;

    private String userName;

    @DBRef(lazy = true)
    private List<PostMongoDB> posts;

    @DBRef(lazy = true)
    private List<LikeMongoDB> likes;

    @DBRef(lazy = true)
    private List<CommentMongoDB> comments;

    public UserMongoDB() {
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public List<PostMongoDB> getPosts() {
        return posts;
    }

    public void setPosts(List<PostMongoDB> posts) {
        this.posts = posts;
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
}
