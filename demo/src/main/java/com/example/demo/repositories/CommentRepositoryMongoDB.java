package com.example.demo.repositories;

import com.example.demo.models.CommentMongoDB;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepositoryMongoDB extends MongoRepository<CommentMongoDB, Integer> {
}
