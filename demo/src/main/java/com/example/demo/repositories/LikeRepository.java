package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Like;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer>, JpaSpecificationExecutor {
    List<Like> findLikeByPostId(int postId);
}
