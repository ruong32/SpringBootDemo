package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

import com.example.demo.models.*;
import com.example.demo.services.*;

@RestController
public class LikeController {
    @Autowired
    private LikeServices likeServices; 
    @Autowired
    private PostServices postServices;
    @Autowired
    private UserServices userServices;

    @PostMapping(value="/like")
    public @ResponseBody boolean createLike(@RequestBody Like like) {
        if (userServices.findUserById(like.getUser().getId()).isEmpty()){
            return false;
        }
        if (postServices.findPostById(like.getPost().getId()).isEmpty()){
            return false;
        }
        if (likeServices.isDuplicated(like.getUser().getId(), like.getPost().getId())){
            return false;
        }
        return likeServices.createLike(like);
    }

    @DeleteMapping(value = "/unlike")
    public @ResponseBody boolean unlike(@RequestBody Like like){
        return likeServices.unlike(like.getUser().getId(), like.getPost().getId());
    }
    
}