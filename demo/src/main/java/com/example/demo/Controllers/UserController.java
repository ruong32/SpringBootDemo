package com.example.demo.controllers;

import com.example.demo.dto.PostDTO;
import com.example.demo.dto.UserDTO;
import com.example.demo.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.models.*;
import com.example.demo.services.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {
  @Autowired
  private UserServices userServices;

  @PostMapping(path = "/createUser")
  public @ResponseBody boolean createUser(@RequestBody UserDTO userDTO) {
    if (userDTO.getUserName() == null) return false;
    User userWillCreate = Converter.fromTo(userDTO, User.class);
    return userServices.createUser(userWillCreate);
  }

  @DeleteMapping(path = "/deleteUserById")
  public @ResponseBody boolean deleteUserById(@RequestBody int userId){
    userServices.deleteUser(userId);
    return true;
  }

  @GetMapping(path = "/getAllPostsOfUser/{userId}")
  public @ResponseBody List<PostDTO> getAllPosts (@PathVariable int userId){
    Optional<User> user = userServices.findUserById(userId);
    List<Post> resultList = user.get().getPosts();
    return Converter.fromToList(resultList, PostDTO.class);
  }

  @GetMapping(path = "/getUserById/{id}")
  public @ResponseBody UserDTO getUserById(@PathVariable int id) {
    Optional<User> user = userServices.findUserById(id);
    if (user.isEmpty()) return null;
    return Converter.fromTo(user.get(), UserDTO.class);
  }

  @GetMapping(path = "/findUserByName/{name}")
  public @ResponseBody List<UserDTO> getUserByName(@PathVariable String name) {
    List<User> resultList = userServices.findByName(name);
    return Converter.fromToList(resultList, UserDTO.class);
  }
}