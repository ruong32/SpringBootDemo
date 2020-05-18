package com.example.demo.services;

import com.example.demo.models.Like;
import com.example.demo.specifications.PostSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.PostRepository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.models.Post;

@Service
public class PostServices {
  @Autowired
  private PostRepository repository;

  public boolean createPost(Post post) {
    repository.save(post);
    return true;
  }

  public Optional<Post> findPostById(int id) {
    return repository.findById(id);
  }

  public List<Post> findPostByContent(String find) {
    return repository.findAll(PostSpecs.hasContent(find));
  }

  public List<Post> findPostFromDate(Date date) {
    return repository.findAll(PostSpecs.laterThan(date));
  }

}