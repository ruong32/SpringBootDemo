package com.example.demo.services;

import com.example.demo.responseObjects.GetAllLikesOfPostResponse;
import com.example.demo.specifications.LikeSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.repositories.LikeRepository;
import com.example.demo.models.*;

import java.util.List;
import java.util.Optional;

@Service
public class LikeServices {

    @Autowired
    private LikeRepository repository;

    public boolean createLike(Like like) {
        Like savedLike = repository.save(like);
        if (savedLike != null)
          return true;
        return false;
    }

    public boolean unlike(int userId, int postId) {
        Optional<Like> like = repository.findOne(LikeSpecs.has("user", userId).and(LikeSpecs.has("post", postId)));
        if (like.isEmpty()) {
            return false;
        }
        repository.delete(like.get());
        return true;
    }

    public boolean isDuplicated(int userId, int postId){
        return repository.findAll(LikeSpecs.has("user", userId).and(LikeSpecs.has("post", postId))).size() != 0;
    }


    public List<GetAllLikesOfPostResponse> getAllLikesOfPost(int postId) {
        return repository.findLikeByPostId(postId);
    }
}