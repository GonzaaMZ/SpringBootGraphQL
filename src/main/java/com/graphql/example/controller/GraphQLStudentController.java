package com.graphql.example.controller;

import com.graphql.example.entities.Course;
import com.graphql.example.entities.Student;
import com.graphql.example.graphql.InputStudent;
import com.graphql.example.service.ICourseService;
import com.graphql.example.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class GraphQLStudentController {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICourseService courseService;

    @QueryMapping(name = "findStudentById")
    public Student findById(@Argument(name = "studentId") String id){
        Long studentId = Long.parseLong(id);

        return studentService.findById(studentId);
    }

    @QueryMapping(name = "findAllStudents")
    public List<Student> findAll(){
        return studentService.findAll();
    }

    // SI EL NOMBRE DEL METODO O ARGUMENTO EN GRAPHQL ES IGUAL AL DEL CONTROLLER NO ES NECESARIO ESPECIFICAR SU NOMBRE
    //EJ: @MutationMapping(name = "createStudent")
    //EJ: @MutationMapping
    // Ej: @Argument(name = "inputStudent")
    // Ej: @Argument
    //Funcionan las 2 formas
    @MutationMapping(name = "createStudent")
    public Student createStudent(@Argument InputStudent inputStudent){

        Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

            Student student = Student.builder()
                    .name(inputStudent.getName())
                    .lastName(inputStudent.getLastName())
                    .age(inputStudent.getAge())
                    .course(course)
                    .build();

            studentService.create(student);

            return student;
    }

    @MutationMapping
    public String deleteStudent(@Argument(name = "studentId") String id){
            studentService.delete(Long.parseLong(id));
            return "Student with ID " + id + " deleted successfully";
    }

}
