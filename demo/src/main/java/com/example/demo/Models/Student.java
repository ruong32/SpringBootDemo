package com.example.demo.Models;

import javax.persistence.*;

@Entity
@Table(name = "Students")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    public Student(){

    }

    public Student(String name, String address, String dateOfBirth){
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

    public String getDateOfBirth(){
        return this.dateOfBirth;
    }

    public String setName(String name){
        return this.name;
    }

    public String setAddress(String address){
        return this.address;
    }

    public String setDateOfBirth(String dateOfBirth){
        return this.dateOfBirth;
    }

}