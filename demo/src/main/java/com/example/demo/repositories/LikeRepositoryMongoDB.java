package com.example.demo.repositories;

import com.example.demo.models.LikeMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepositoryMongoDB extends MongoRepository<LikeMongoDB, Integer> {
}
