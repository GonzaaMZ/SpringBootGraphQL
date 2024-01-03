package com.graphql.example.service.implementation;

import com.graphql.example.entities.Student;
import com.graphql.example.persistence.ICourseDao;
import com.graphql.example.persistence.IStudentDao;
import com.graphql.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Override
    @Transactional(readOnly = true)
    public Student findById(Long id) {
        return studentDao.findById(id).orElseThrow();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return (List<Student>) studentDao.findAll();
    }

    @Override
    @Transactional
    public Student create(Student student) {
        return studentDao.save(student);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        studentDao.deleteById(id);
    }
}
