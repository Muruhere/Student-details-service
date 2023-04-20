package com.backend.servicerepo.Controller;

import com.backend.servicerepo.Dao.DynamoDBRepository;
import com.backend.servicerepo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private DynamoDBRepository dynamoDBRepository;

    @GetMapping("/{Id}")
    public Student getStudent(@PathVariable("Id") String studentId) {
        return dynamoDBRepository.fetchStudent(studentId);
    }

    @PostMapping("/add")
    public Student addStudent(@RequestBody Student student) {
        return dynamoDBRepository.saveStudent(student);
    }

    @PutMapping("/update")
    public String updateStudent(@RequestBody Student student) {
        return dynamoDBRepository.updateStudent(student);
    }

    @DeleteMapping("/deletet")
    public String deleteStudent(@PathVariable String studentId) {
        return dynamoDBRepository.deleteStudent(studentId);
    }
}
