package com.example.demo.controllers;

import com.example.demo.dto.LikeDTO;
import com.example.demo.dto.LikeDTOMongoDB;
import com.example.demo.dto.PostDTO;
import com.example.demo.dto.PostDTOMongDB;
import com.example.demo.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.*;
import com.example.demo.services.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
public class PostController {

  @Autowired
  private PostServices postServices;
  @Autowired
  private UserServices userServices;
  @Autowired
  private LikeServices likeServices;
  @Autowired
  private UserServicesMongoDB userServicesMongoDB;
  @Autowired
  private PostServicesMongoDB postServicesMongoDB;
  @Autowired
  private LikeServicesMongoDB likeServicesMongoDB;

  @PostMapping(path = "/createPost", consumes = MediaType.APPLICATION_JSON_VALUE)
  public @ResponseBody boolean createPost(@RequestBody PostDTO postDTO) {
    if (userServicesMongoDB.findUserById(postDTO.getPoster().getId()).isEmpty()){
      return false;
    }
    Post postWillCreate = Converter.fromTo(postDTO, Post.class);
    PostMongoDB postMongoDB = Converter.fromTo(postDTO, PostMongoDB.class);
    postMongoDB.setCreatedAt(new Date(System.currentTimeMillis() + 7 * 3600 * 1000));
    return postServicesMongoDB.createPost(postMongoDB) && postServices.createPost(postWillCreate);
  }

  @GetMapping(path="/findPostByContent/{find}")
  public @ResponseBody List<PostDTOMongDB> findPostByContent(@PathVariable String find) {
    List<PostMongoDB> resultList = postServicesMongoDB.findPostByContent(find);
    return Converter.fromToList(resultList, PostDTOMongDB.class);
  }

  @GetMapping(path="/findPostFromDate")
  public @ResponseBody List<PostDTO> findPostFromDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
    List<PostMongoDB> resultList = postServicesMongoDB.findPostFromDate(date);
    return Converter.fromToList(resultList, PostDTO.class);
  }

  @GetMapping(path="/getAllLikesOfPost/{postId}")
  public @ResponseBody List<LikeDTOMongoDB> getAllLikesOfPost(@PathVariable int postId) {
    List<LikeMongoDB> resultList = likeServicesMongoDB.getAllLikesOfPost(postId);
    return Converter.fromToList(resultList, LikeDTOMongoDB.class);
  }

  @DeleteMapping(path = "/deletePostById")
  public @ResponseBody boolean deletePostById(@RequestBody int postId){
    postServices.deletePostById(postId);
    postServicesMongoDB.deletePostById(postId);
    return true;
  }

  @GetMapping(path = "/getAllPostsOfUser/{userId}")
  public @ResponseBody List<PostDTO> getAllPosts (@PathVariable int userId){
    List<PostMongoDB> postMongoDBList = postServicesMongoDB.getPostByUserId(userId);
    return Converter.fromToList(postMongoDBList, PostDTO.class);
  }

}