package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.PostRepository;
import com.example.demo.models.Post;

import java.util.List;

@Service
public class PostServices {
  @Autowired
  private PostRepository repository;

  public boolean createPost(Post post) {
    repository.save(post);
    return true;
  }

}