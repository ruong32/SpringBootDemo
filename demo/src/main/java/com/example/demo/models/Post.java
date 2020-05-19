package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private List<Like> likes = new ArrayList<Like>();

  @OneToMany(mappedBy = "post", cascade = CascadeType.ALL)
  private List<Comment> comments = new ArrayList<Comment>();

  @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  public Post() {
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

  public User getPoster() {
    return poster;
  }

  public void setPoster(User poster) {
    this.poster = poster;
  }

  public List<Like> getLikes() {
    return likes;
  }

  public void setLikes(List<Like> likes) {
    this.likes = likes;
  }

  public List<Comment> getComments() {
    return comments;
  }

  public void setComments(List<Comment> comments) {
    this.comments = comments;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }
}