package com.example.demo.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Collection;

@Entity
@Table(name = "Users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String userName;

  @OneToMany(mappedBy = "poster")
  private Collection<Post> posts;

  @OneToMany(mappedBy = "user")
  private Collection<Like> likes;

  // contructor
  public User(String userName) {
    this.userName = userName;
  }

  // setter, getter
  // id
  public int getId() {
    return this.id;
  }

  // posts
  public Collection<Post> getPosts() {
    return this.posts;
  }

  // likes
  public Collection<Like> getLikes() {
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