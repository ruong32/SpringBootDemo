package com.example.demo.services;

import com.example.demo.models.Comment;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.specifications.CommentSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServices {
    @Autowired
    private CommentRepository repository;

    public boolean createComment(Comment comment) {
        Comment savedPost = repository.save(comment);
        if (savedPost != null)
            return true;
        return false;
    }

    public List<Comment> getAllCommentOfPost(int postId) {
        return repository.findAll(CommentSpecs.has("post", postId));
    }

    public boolean deleteComment(int commentId) {
        repository.deleteById(commentId);
        return true;
    };
}