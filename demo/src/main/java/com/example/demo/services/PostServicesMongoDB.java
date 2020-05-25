package com.example.demo.services;

import com.example.demo.models.Post;
import com.example.demo.models.PostMongoDB;
import com.example.demo.repositories.PostRepositoryMongoDB;
import com.example.demo.specifications.PostSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServicesMongoDB {

    @Autowired
    private PostRepositoryMongoDB postRepositoryMongoDB;

    public boolean createPost(PostMongoDB post) {
        postRepositoryMongoDB.save(post);
        return true;
    }

    public Optional<PostMongoDB> findPostById(int id) {
        return postRepositoryMongoDB.findById(id);
    }

    public List<PostMongoDB> findPostByContent(String find) {
        return postRepositoryMongoDB.findAllByContent(find);
    }

    public List<PostMongoDB> findPostFromDate(Date date) {
        return postRepositoryMongoDB.findAllFromDate(date);
    }

    public boolean deletePostById(int postId) {
        postRepositoryMongoDB.deleteById(postId);
        return true;
    }

    public List<PostMongoDB> getPostByUserId(int userId){
        return postRepositoryMongoDB.findAllByPosterId(userId);
    }
}
