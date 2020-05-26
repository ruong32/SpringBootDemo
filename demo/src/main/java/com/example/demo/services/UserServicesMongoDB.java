package com.example.demo.services;

import com.example.demo.models.UserMongoDB;
import com.example.demo.repositories.UserRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServicesMongoDB {
    @Autowired
    private UserRepositoryMongoDB userRepositoryMongoDB;
    @Autowired
    private PostServicesMongoDB postServicesMongoDB;
    @Autowired
    private LikeServicesMongoDB likeServicesMongoDB;
    @Autowired
    private CommentServicesMongoDB commentServicesMongoDB;

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
        likeServicesMongoDB.deleteAllLikeOfUser(id);
        commentServicesMongoDB.deleteAllCommentOfUser(id);
        postServicesMongoDB.deleteAllPostOfUser(id);
        userRepositoryMongoDB.deleteById(id);
    }

    public List<UserMongoDB> findByName(String name){
        return userRepositoryMongoDB.findAllByUserName(name);
    }
}
