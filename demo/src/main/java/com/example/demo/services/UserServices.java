package com.example.demo.services;

import com.example.demo.models.OutBox;
import com.example.demo.specifications.UserSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.UserRepository;
import com.example.demo.models.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices {
  @Autowired
  private UserRepository repository;
  @Autowired
  private OutBoxServices outBoxServices;

  public boolean createUser(User user) {
    User savedUser = repository.save(user);
    String payload = "{id:" + savedUser.getId() + ", userName:" + savedUser.getUserName()+"}";
    OutBox outBox = new OutBox().setAggregateId(savedUser.getId()).setAggregateType("user").setType("c").setPayload(payload);
    outBoxServices.handleOutBoxEvent(outBox);
    if (savedUser != null)
      return true;
    return false;
  }

  public Optional<User> findUserById(int id) {
    return repository.findById(id);
  }

  public void deleteUser(int id){
    repository.deleteById(id);
  }

  public List<User> findByName(String name){
    return repository.findAll(UserSpecs.userNameIs(name));
  }
}
