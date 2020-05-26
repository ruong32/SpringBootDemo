package com.example.demo.services;

import com.example.demo.models.LikeMongoDB;
import com.example.demo.repositories.LikeRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServicesMongoDB {
    @Autowired
    private LikeRepositoryMongoDB likeRepositoryMongoDB;

    public boolean createLike(LikeMongoDB like) {
        LikeMongoDB savedLike = likeRepositoryMongoDB.save(like);
        if (savedLike != null)
            return true;
        return false;
    }

    public boolean unlike(int userId, int postId) {
        Optional<LikeMongoDB> like = likeRepositoryMongoDB.findOne(userId, postId);
        if (like.isEmpty()) {
            return false;
        }
        likeRepositoryMongoDB.delete(like.get());
        return true;
    }

    public boolean isDuplicated(int userId, int postId){
        return likeRepositoryMongoDB.findAll(userId, postId).size() != 0;
    }


    public List<LikeMongoDB> getAllLikesOfPost(int postId) {
        return likeRepositoryMongoDB.findLikeByPostId(postId);
    }

    public void deleteAllLikeOfUser(int userId){
        likeRepositoryMongoDB.deleteAllLikeOfUser(userId);
    }

    public void deleteAllLikeOfPost(int postId){
        likeRepositoryMongoDB.deleteAllLikeOfPost(postId);
    }
}
