package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.models.Like;

public interface LikeRepository extends JpaRepository<Like, Integer> {

}
