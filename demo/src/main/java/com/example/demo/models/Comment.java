package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
  private User user;

  @Column(nullable = false)
  private String content;

  @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  // constructor
  public Comment(String content) {
    this.content = content;
  }

  // getter, setter
  // id
  public int getId() {
    return this.id;
  }

  // content
  public String getContent() {
    return this.content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  // user
  @JsonIgnore
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  // post
  @JsonIgnore
  public Post getPost() {
    return this.post;
  }

  public void setPost(Post post) {
    this.post = post;
  }

  // createdAt
  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}