package com.example.demo.repositories;

import com.example.demo.models.OutBox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutBoxRepository extends JpaRepository<OutBox, Integer> {
}
