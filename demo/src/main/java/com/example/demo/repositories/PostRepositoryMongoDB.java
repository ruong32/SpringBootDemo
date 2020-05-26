package com.example.demo.repositories;

import com.example.demo.models.PostMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PostRepositoryMongoDB extends MongoRepository<PostMongoDB, Integer> {
    @Query("{'content': {$regex: ?0}}")
    List<PostMongoDB> findAllByContent(String find);

    @Query("{'poster.$id': {$eq: ?0}}")
    List<PostMongoDB> findAllByPosterId(int id);

    @Query("{'createdAt' : {$gte: ?0}}")
    List<PostMongoDB> findAllFromDate(Date date);

    @Query(value = "{'poster.$id': {$eq: ?0}}", delete = true)
    void deleteAllPostOfUser(int id);
}
