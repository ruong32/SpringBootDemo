package com.example.demo.repositories;

import com.example.demo.responseObjects.GetAllLikesOfPostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Like;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer>, JpaSpecificationExecutor {
    List<GetAllLikesOfPostResponse> findLikeByPostId(int postId);
}
