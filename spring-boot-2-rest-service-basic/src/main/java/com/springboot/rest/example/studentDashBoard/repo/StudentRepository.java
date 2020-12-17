package com.springboot.rest.example.studentDashBoard.repo;

import com.springboot.rest.example.studentDashBoard.model.Student;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public interface StudentRepository {

    List<Student> findAll() throws SQLException;

    Student findById(long id);

    int deleteById(long id);

    int save(Student student);
}
