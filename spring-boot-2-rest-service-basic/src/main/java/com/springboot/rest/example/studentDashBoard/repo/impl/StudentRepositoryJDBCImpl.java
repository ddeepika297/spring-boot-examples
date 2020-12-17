package com.springboot.rest.example.studentDashBoard.repo.impl;

import com.springboot.rest.example.studentDashBoard.model.Student;
import com.springboot.rest.example.studentDashBoard.repo.StudentRepository;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
@Repository
public class StudentRepositoryJDBCImpl implements StudentRepository {
    public Connection getConnection() throws SQLException {

        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");

        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/",
                connectionProps);
        System.out.println("Connected to database");
        return conn;
    }

    public List<Student> findAll() throws SQLException {

        String query = "select * from student";
        List<Student> studentList = new ArrayList<>();
        try (Statement stmt = getConnection().createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Student student = new Student();
                student.setStudentId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setBranch(rs.getString("branch"));
                student.setSemester(rs.getInt("semester"));
                studentList.add(student);
            }
        } catch (SQLException e) {
            throw new SQLException("exception while fetching student");
        }
        return studentList;
    }

    @Override
    public Student findById(long id) {
        return null;
    }

    @Override
    public int deleteById(long id) {
        return 0;
    }

    @Override
    public int save(Student student) {
        return 0;
    }
}
