package com.graphql.example.persistence;

import com.graphql.example.entities.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStudentDao extends CrudRepository<Student, Long> {
}
