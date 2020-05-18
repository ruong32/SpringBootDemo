package com.example.demo.controllers;

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
  public @ResponseBody boolean createUser(@RequestBody User user) {
    if (user.equals(null)) return false;
    return userServices.createUser(user);
  }

  @DeleteMapping(path = "/deleteUser")
  public @ResponseBody boolean deleteUser(@RequestBody int id){
    userServices.deleteUser(id);
    return true;
  }

  @GetMapping(path = "/getAllPosts/{id}")
  public @ResponseBody List<Post> getAllPosts (@PathVariable int id){
    Optional<User> user = userServices.findUserById(id);
    List<Post> result = user.get().getPosts();
    return result;
  }

  @GetMapping(path = "/getUserById/{id}")
  public @ResponseBody User getUserById(@PathVariable int id) {
    Optional<User> user = userServices.findUserById(id);
    if (user.isEmpty()) return null;
    return user.get();
  }

  @GetMapping(path = "/findUserByName/{name}")
  public @ResponseBody List<User> getUserByName(@PathVariable String name) {
    return userServices.findByName(name);
  }
}