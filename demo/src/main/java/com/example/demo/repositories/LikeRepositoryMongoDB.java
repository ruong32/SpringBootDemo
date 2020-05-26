package com.example.demo.repositories;

import com.example.demo.models.LikeMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LikeRepositoryMongoDB extends MongoRepository<LikeMongoDB, Integer> {
    @Query("{$and: [{'user.$id': {$eq: ?0}}, {'post.$id': {$eq: ?1}}]}")
    Optional<LikeMongoDB> findOne(int userId, int postId);

    @Query("{$and: [{'user.$id': {$eq: ?0}}, {'post.$id': {$eq: ?1}}]}")
    List<LikeMongoDB> findAll(int userId, int postId);

    @Query("{'post.$id': {$eq: ?0}}")
    List<LikeMongoDB> findLikeByPostId(int postId);

    @Query(value = "{'user.$id': {$eq: ?0}}", delete = true)
    void deleteAllLikeOfUser(int userId);

    @Query(value = "{'post.$id': {$eq: ?0}}", delete = true)
    void deleteAllLikeOfPost(int postId);
}
