package com.example.demo.controllers;

import com.example.demo.dto.UserDTO;
import com.example.demo.dto.UserDTOMongoDB;
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
  @Autowired
  private UserServicesMongoDB userServicesMongoDB;

  @PostMapping(path = "/createUser")
  public @ResponseBody boolean createUser(@RequestBody UserDTO userDTO) {
    if (userDTO.getUserName() == null) return false;
    User userWillCreate = Converter.fromTo(userDTO, User.class);
    UserMongoDB userMongoDB = Converter.fromTo(Converter.fromTo(userDTO, UserDTOMongoDB.class), UserMongoDB.class);
    return userServices.createUser(userWillCreate) && userServicesMongoDB.createUser(userMongoDB);
  }

  @DeleteMapping(path = "/deleteUserById")
  public @ResponseBody boolean deleteUserById(@RequestBody int userId){
    userServices.deleteUser(userId);
    userServicesMongoDB.deleteUser(userId);
    return true;
  }

  @GetMapping(path = "/getUserById/{id}")
  public @ResponseBody UserDTOMongoDB getUserById(@PathVariable int id) {
    Optional<UserMongoDB> user = userServicesMongoDB.findUserById(id);
    if (user.isEmpty()) return null;
    return Converter.fromTo(user.get(), UserDTOMongoDB.class);
  }

  @GetMapping(path = "/findUserByName/{name}")
  public @ResponseBody List<UserDTOMongoDB> getUserByName(@PathVariable String name) {
    List<UserMongoDB> resultList = userServicesMongoDB.findByName(name);
    return Converter.fromToList(resultList, UserDTOMongoDB.class);
  }
}