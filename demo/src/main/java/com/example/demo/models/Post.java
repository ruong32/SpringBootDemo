package com.example.demo.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String content;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "poster_id", referencedColumnName = "id", nullable = false)
  private User poster;

  @OneToMany(mappedBy = "post")
  private List<Like> likes = new ArrayList<Like>();

  @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  // constructor
  public Post() {

  }

  public Post(String content) {
    this.content = content;
  }

  // setter, getter
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
    return this.poster;
  }

  public void setUser(User poster) {
    this.poster = poster;
  }

  // like
  public List<Like> getLikes() {
    return this.likes;
  }

  // createdAt
  public Date getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

}