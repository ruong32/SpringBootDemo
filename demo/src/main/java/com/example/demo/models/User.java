package com.example.demo.models;

import javax.persistence.*;

import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String userName;

  @OneToMany(mappedBy = "poster", cascade = CascadeType.ALL)
  private List<Post> posts = new ArrayList<Post>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL )
  private List<Like> likes = new ArrayList<Like>();

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL )
  private List<Comment> comments = new ArrayList<Comment>();

  // contructor
  public User() {

  }

  public User(String userName) {
    this.userName = userName;
  }

  // setter, getter
  // id
  public int getId() {
    return this.id;
  }

  // posts
  public List<Post> getPosts() {
    return this.posts;
  }

  // likes
  public List<Like> getLikes() {
    return this.likes;
  }

  // username
  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

}