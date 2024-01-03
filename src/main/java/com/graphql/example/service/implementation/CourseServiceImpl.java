package com.graphql.example.service.implementation;

import com.graphql.example.entities.Course;
import com.graphql.example.persistence.ICourseDao;
import com.graphql.example.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    @Autowired
    private ICourseDao courseDao;

    @Override
    @Transactional(readOnly = true)
    public Course findById(Long id) {
        return courseDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return (List<Course>) courseDao.findAll();
    }

    @Override
    @Transactional
    public Course create(Course course) {
        return courseDao.save(course);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        courseDao.deleteById(id);
    }
}
