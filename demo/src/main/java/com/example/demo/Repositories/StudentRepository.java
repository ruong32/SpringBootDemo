package com.example.demo.Repositories;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.Models.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{
}