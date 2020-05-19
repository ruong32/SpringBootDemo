package com.example.demo.controllers;

import com.example.demo.dto.CommentDTO;
import com.example.demo.models.Comment;
import com.example.demo.services.CommentServices;
import com.example.demo.services.PostServices;
import com.example.demo.services.UserServices;
import com.example.demo.utilities.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentServices commentServices;
    @Autowired
    private UserServices userServices;
    @Autowired
    private PostServices postServices;

    @PostMapping(path = "/createComment")
    public @ResponseBody boolean createComment(@RequestBody CommentDTO commentDTO){
        if (userServices.findUserById(commentDTO.getUser().getId()).isEmpty()){
            return false;
        }
        if (postServices.findPostById(commentDTO.getPostId()).isEmpty()){
            return false;
        }
        Comment commentWillCreate = Converter.fromTo(commentDTO, Comment.class);
        return commentServices.createComment(commentWillCreate);
    }

    @GetMapping(path = "/getAllCommentOfPost/{postId}")
    public @ResponseBody List<CommentDTO> getAllCommentOfPost(@PathVariable int postId) {
        List<Comment> resultList = commentServices.getAllCommentOfPost(postId);
        return Converter.fromToList(resultList, CommentDTO.class);
    }

    @DeleteMapping(path = "/deleteComment")
    public @ResponseBody boolean deleteComment(@RequestBody int commentId) {
        commentServices.deleteComment(commentId);
        return true;
    }

}