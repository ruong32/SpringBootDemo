package com.example.demo.services;

import com.example.demo.repositories.CommentRepositoryMongoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServicesMongoDB {
    @Autowired
    private CommentRepositoryMongoDB repositoryMongoDB;
}
