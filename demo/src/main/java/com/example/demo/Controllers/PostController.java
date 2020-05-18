package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.*;
import com.example.demo.services.*;

import java.util.Date;
import java.util.List;

@RestController
public class PostController {

  @Autowired
  private PostServices postServices;
  @Autowired
  private UserServices userServices;
  @Autowired
  private LikeServices likeServices;

  @PostMapping(path = "/createPost", consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody boolean createPost(@RequestBody Post post) {
    if (userServices.findUserById(post.getUser().getId()).isEmpty()){
      return false;
    }
    return postServices.createPost(post);
  }

  @GetMapping(path="/findPostByContent/{find}")
  public @ResponseBody List<Post> findPostByContent(@PathVariable String find) {
    return postServices.findPostByContent(find);
  }

  @GetMapping(path="/findPostFromDate")
  public @ResponseBody List<Post> findPostFromDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    return postServices.findPostFromDate(date);
  }

  @GetMapping(path="/getAllLikesOfPost/{postId}")
  public @ResponseBody List<Like> getAllLikesOfPost(@PathVariable int postId) {
    return likeServices.getAllLikesOfPost(postId);
  }

}