package com.graphql.example.service;

import com.graphql.example.entities.Course;
import com.graphql.example.entities.Student;

import java.util.List;

public interface ICourseService {

    Course findById(Long id);

    List<Course> findAll();

    Course create(Course course);

    void delete(Long id);
}
