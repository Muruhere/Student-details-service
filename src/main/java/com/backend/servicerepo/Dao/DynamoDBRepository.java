package com.backend.servicerepo.Dao;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBSaveExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ExpectedAttributeValue;
import com.backend.servicerepo.Entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DynamoDBRepository {

    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Student saveStudent(Student student) {
        System.out.print(dynamoDBMapper);
        dynamoDBMapper.save(student);
        return student;
    }

    public Student fetchStudent(String studentId) {
        return dynamoDBMapper.load(Student.class, studentId);

    }

    public String deleteStudent(String studentId) {
        Student student = dynamoDBMapper.load(Student.class, studentId);
        dynamoDBMapper.delete(student);
        return "Student deleted " + studentId;
    }

    public String updateStudent(Student student) {
        dynamoDBMapper.save(student, new DynamoDBSaveExpression()
                .withExpectedEntry("Id", new ExpectedAttributeValue(
                        new AttributeValue().withS(student.getUserId())
                )));
        return "Student updated " + student.getUserId();
    }


}
