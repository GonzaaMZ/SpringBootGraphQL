package com.graphql.example.controller;

import com.graphql.example.entities.Course;
import com.graphql.example.graphql.InputCourse;
import com.graphql.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class GraphQLCourseController {

    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findCourseById")
    public Course findById(@Argument(name = "courseId") String id) {
        Long courseId = Long.parseLong(id);
        return courseService.findById(courseId);
    }

    @QueryMapping(name = "findAllCourses")
    public List<Course> findAll() {
        return courseService.findAll();
    }

    @MutationMapping
    public Course createCourse(@Argument InputCourse inputCourse) {
        Course course = Course.builder()
                .name(inputCourse.getName())
                .category(inputCourse.getCategory())
                .teacher(inputCourse.getTeacher())
                .build();
        return courseService.create(course);
    }

    @MutationMapping
    public String deleteCourse(@Argument(name = "courseId") String id) {
        courseService.delete(Long.parseLong(id));
        return "Course with ID: " + id + " deleted";
    }

}
