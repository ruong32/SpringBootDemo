package com.example.demo.Controllers;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.Repositories.StudentRepository;
import com.example.demo.Models.Student;

@RestController
public class StudentController {
    @Autowired
    StudentRepository repository;

    @PostMapping("/create")
    public @ResponseBody String addStudent(@RequestParam String name,
            @RequestParam String address, @RequestParam String dateOfBirth) {
        repository.save(new Student(name, address, dateOfBirth));
        return name + " created!";
    }

    @GetMapping("/findAll")
    public @ResponseBody Iterable<Student> getAllStudents() {
        Iterable<Student> students = repository.findAll();
        return students;
    }

    @GetMapping("/findById/{id}")
    public @ResponseBody Optional<Student> findStudentById(@PathVariable int id) {
        Optional<Student> student = repository.findById(id);
        return student;
    }

    @DeleteMapping("/deleteById/{id}")
    public @ResponseBody String deleteById(@PathVariable int id) {
        repository.deleteById(id);
        return "deleted!";
    }

    @PutMapping("/updateStudent")
    public @ResponseBody String updateStudent(){
        return "user updated!";
    }
}