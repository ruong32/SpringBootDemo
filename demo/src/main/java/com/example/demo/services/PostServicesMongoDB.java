package com.example.demo.services;

import com.example.demo.models.PostMongoDB;
import com.example.demo.repositories.PostRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostServicesMongoDB {

    @Autowired
    private PostRepositoryMongoDB postRepositoryMongoDB;
    @Autowired
    private LikeServicesMongoDB likeServicesMongoDB;
    @Autowired
    private CommentServicesMongoDB commentServicesMongoDB;

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
        commentServicesMongoDB.deleteAllCommentOfPost(postId);
        likeServicesMongoDB.deleteAllLikeOfPost(postId);
        postRepositoryMongoDB.deleteById(postId);
        return true;
    }

    public void deleteAllPostOfUser(int userId) {
        postRepositoryMongoDB.deleteAllPostOfUser(userId);
    }

    public List<PostMongoDB> getPostByUserId(int userId){
        return postRepositoryMongoDB.findAllByPosterId(userId);
    }
}
