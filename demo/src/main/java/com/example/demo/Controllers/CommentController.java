package com.example.demo.controllers;

import com.example.demo.dto.CommentDTO;
import com.example.demo.dto.CommentDTOMongoDB;
import com.example.demo.models.Comment;
import com.example.demo.models.CommentMongoDB;
import com.example.demo.services.*;
import com.example.demo.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentServices commentServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private PostServices postServices;
    @Autowired
    private CommentServicesMongoDB commentServicesMongoDB;
    @Autowired
    private UserServicesMongoDB userServicesMongoDB;
    @Autowired
    private PostServicesMongoDB postServicesMongoDB;

    @PostMapping(path = "/createComment")
    public @ResponseBody boolean createComment(@RequestBody CommentDTO commentDTO){
        // mariadb
        if (userServices.findUserById(commentDTO.getUser().getId()).isEmpty()){
            return false;
        }
        if (postServices.findPostById(commentDTO.getPostId()).isEmpty()){
            return false;
        }
        Comment commentWillCreate = Converter.fromTo(commentDTO, Comment.class);

        // mongodb
        if (userServicesMongoDB.findUserById(commentDTO.getUser().getId()).isEmpty()){
            return false;
        }
        if (postServicesMongoDB.findPostById(commentDTO.getPostId()).isEmpty()){
            return false;
        }
        CommentMongoDB commentMongoDB = Converter.fromTo(commentDTO, CommentMongoDB.class);
        commentMongoDB.setCreatedAt(new Date(System.currentTimeMillis() + 7 * 3600 * 1000));

        return commentServices.createComment(commentWillCreate)&&commentServicesMongoDB.createComment(commentMongoDB);
    }

    @GetMapping(path = "/getAllCommentOfPost/{postId}")
    public @ResponseBody List<CommentDTOMongoDB> getAllCommentOfPost(@PathVariable int postId) {
        List<CommentMongoDB> resultList = commentServicesMongoDB.getAllCommentOfPost(postId);
        return Converter.fromToList(resultList, CommentDTOMongoDB.class);
    }

    @DeleteMapping(path = "/deleteCommentById")
    public @ResponseBody boolean deleteComment(@RequestBody int commentId) {
        return commentServices.deleteComment(commentId) && commentServicesMongoDB.deleteComment(commentId);
    }

}