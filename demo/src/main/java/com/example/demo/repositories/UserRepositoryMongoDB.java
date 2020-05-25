package com.example.demo.repositories;

import com.example.demo.models.UserMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepositoryMongoDB extends MongoRepository<UserMongoDB, Integer> {
    @Query("{'userName': {$regex: ?0}}")
    List<UserMongoDB> findAllByUserName(String userName);
}
