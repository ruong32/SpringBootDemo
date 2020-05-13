package com.example.demo.Models;

import java.time.*;

public class Student {
    private String id;
    private String name;
    private String address;
    private LocalDate dateOfBirth;

    public Student(){

    }

    public Student(String name, String address, LocalDate dateOfBirth){
        this.name = name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public LocalDate getDateOfBirth(){
        return this.dateOfBirth;
    }

    public String setName(String name){
        return this.name;
    }

    public String setAddress(String address){
        return this.address;
    }

    public LocalDate setDateOfBirth(LocalDate dateOfBirth){
        return this.dateOfBirth;
    }

}