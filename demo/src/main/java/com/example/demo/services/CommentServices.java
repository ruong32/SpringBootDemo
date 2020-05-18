package com.example.demo.services;

import com.example.demo.models.Like;
import com.example.demo.models.Post;
import com.example.demo.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServices {
    @Autowired
    private PostRepository repository;

    public boolean createPost(Post post) {
        Post savedPost = repository.save(post);
        if (savedPost != null)
            return true;
        return false;
    }
}