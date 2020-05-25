package com.example.demo.services;

import com.example.demo.models.User;
import com.example.demo.models.UserMongoDB;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.PostRepositoryMongoDB;
import com.example.demo.repositories.UserRepositoryMongoDB;
import com.example.demo.specifications.UserSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesMongoDB {
    @Autowired
    private UserRepositoryMongoDB userRepositoryMongoDB;
    @Autowired
    private PostRepositoryMongoDB postRepositoryMongoDB;

    public boolean createUser(UserMongoDB user) {
        UserMongoDB savedUser = userRepositoryMongoDB.save(user);
        if (savedUser != null)
            return true;
        return false;
    }

    public Optional<UserMongoDB> findUserById(int id) {
        return userRepositoryMongoDB.findById(id);
    }

    public void deleteUser(int id){
        userRepositoryMongoDB.deleteById(id);
    }

    public List<UserMongoDB> findByName(String name){
        return userRepositoryMongoDB.findAllByUserName(name);
    }
}
