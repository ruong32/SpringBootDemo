package com.example.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Comments")
public class Comment {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne
  @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
  private Post post;

  @ManyToOne
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
  public User getUser() {
    return this.user;
  }

  // post
  public Post getPost() {
    return this.post;
  }

  // createdAt
  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}