package com.graphql.example.graphql;

import com.graphql.example.entities.Course;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
public class InputStudent {

    private Long id;
    private String name;
    private String lastName;
    private int age;
    private String courseId;

}
