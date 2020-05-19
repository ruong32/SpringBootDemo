package com.example.demo.controllers;

import com.example.demo.dto.LikeDTO;
import com.example.demo.dto.PostDTO;
import com.example.demo.utilities.Converter;
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
  public @ResponseBody boolean createPost(@RequestBody PostDTO postDTO) {
    if (userServices.findUserById(postDTO.getPoster().getId()).isEmpty()){
      return false;
    }
    Post postWillCreate = Converter.fromTo(postDTO, Post.class);
    return postServices.createPost(postWillCreate);
  }

  @GetMapping(path="/findPostByContent/{find}")
  public @ResponseBody List<PostDTO> findPostByContent(@PathVariable String find) {
    List<Post> resultList = postServices.findPostByContent(find);
    return Converter.fromToList(resultList, PostDTO.class);
  }

  @GetMapping(path="/findPostFromDate")
  public @ResponseBody List<PostDTO> findPostFromDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    List<Post> resultList = postServices.findPostFromDate(date);
    return Converter.fromToList(resultList, PostDTO.class);
  }

  @GetMapping(path="/getAllLikesOfPost/{postId}")
  public @ResponseBody List<LikeDTO> getAllLikesOfPost(@PathVariable int postId) {
    List<Like> resultList = likeServices.getAllLikesOfPost(postId);
    return Converter.fromToList(resultList, LikeDTO.class);
  }

  @DeleteMapping(path = "/deletePostById")
  public @ResponseBody boolean deletePostById(@RequestBody int postId){
    postServices.deletePostById(postId);
    return true;
  }

}