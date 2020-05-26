package com.example.demo.services;

import com.example.demo.models.Comment;
import com.example.demo.models.CommentMongoDB;
import com.example.demo.repositories.CommentRepositoryMongoDB;
import com.example.demo.specifications.CommentSpecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServicesMongoDB {
    @Autowired
    private CommentRepositoryMongoDB commentRepositoryMongoDB;

    public boolean createComment(CommentMongoDB comment) {
        CommentMongoDB savedPost = commentRepositoryMongoDB.save(comment);
        if (savedPost != null)
            return true;
        return false;
    }

    public List<CommentMongoDB> getAllCommentOfPost(int postId) {
        return commentRepositoryMongoDB.findAll(postId);
    }

    public boolean deleteComment(int commentId) {
        commentRepositoryMongoDB.deleteById(commentId);
        return true;
    };

    public void deleteAllCommentOfUser(int userId){
        commentRepositoryMongoDB.deleteAllCommentOfUser(userId);
    }

    public void deleteAllCommentOfPost(int postId){
        commentRepositoryMongoDB.deleteAllCommentOfPost(postId);
    }
}
