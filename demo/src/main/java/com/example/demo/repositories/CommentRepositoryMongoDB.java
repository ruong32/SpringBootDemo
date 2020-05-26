package com.example.demo.repositories;

import com.example.demo.models.CommentMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepositoryMongoDB extends MongoRepository<CommentMongoDB, Integer> {
    @Query("{'post.$id': {$eq: ?0}}")
    List<CommentMongoDB> findAll(int postId);

    @Query(value = "{'user.$id': {$eq: ?0}}", delete = true)
    void deleteAllCommentOfUser(int userId);

    @Query(value = "{'post.$id': {$eq: ?0}}", delete = true)
    void deleteAllCommentOfPost(int postId);
}
