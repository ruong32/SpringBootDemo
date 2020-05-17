package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.*;
import com.example.demo.services.*;

import java.sql.SQLException;
import java.util.Optional;

@RestController
public class PostController {

  @Autowired
  private PostServices postServices;
  @Autowired
  private UserServices userServices;

  @PostMapping(path = "/createPost", consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody boolean createPost(@RequestBody Post post) {
    if (userServices.findUserById(post.getUser().getId()).isEmpty()){
      return false;
    }
    return postServices.createPost(post);
  }

}