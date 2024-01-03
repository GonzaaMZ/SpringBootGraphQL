package com.graphql.example.service;

import com.graphql.example.entities.Student;

import java.util.List;

public interface IStudentService {

    Student findById(Long id);

    List<Student> findAll();

    Student create(Student student);

    void delete(Long id);

}
