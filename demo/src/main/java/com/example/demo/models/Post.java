package com.example.demo.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Posts")
public class Post {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(nullable = false)
  private String content;

  @ManyToOne
  @JoinColumn(name = "poster_id", referencedColumnName = "id", nullable = false)
  private User poster;

  @OneToMany(mappedBy = "post")
  private Collection<Like> likes;

  @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
  private Date createdAt;

  // constructor
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

  // like
  public Collection<Like> getLikes() {
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