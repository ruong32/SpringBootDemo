package com.example.demo.controllers;

import com.example.demo.dto.LikeDTO;
import com.example.demo.utilities.Converter;
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
    public @ResponseBody boolean createLike(@RequestBody LikeDTO likeDTO) {
        if (userServices.findUserById(likeDTO.getUser().getId()).isEmpty()){
            return false;
        }
        if (postServices.findPostById(likeDTO.getPostId()).isEmpty()){
            return false;
        }
        if (likeServices.isDuplicated(likeDTO.getUser().getId(), likeDTO.getPostId())){
            return false;
        }
        Like likeWillCreate = Converter.fromTo(likeDTO, Like.class);
        return likeServices.createLike(likeWillCreate);
    }

    @DeleteMapping(value = "/unlike")
    public @ResponseBody boolean unlike(@RequestBody LikeDTO LikeDTO){
        return likeServices.unlike(LikeDTO.getUser().getId(), LikeDTO.getPostId());
    }
    
}