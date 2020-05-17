package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "Likes")
public class Like {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String type = "like"; // like, haha, wow, angry,...

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
  private User user;

  // constructor
  public Like() {

  }

  public Like(String type) {
    this.type = type;
  }

  // setter, getter
  // id
  public int getId() {
    return this.id;
  }

  // type
  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  // user
  public User getUser() {
    return this.user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  // post
  public Post getPost() {
    return this.post;
  }

  public void setPost(Post post) {
    this.post = post;
  }
}