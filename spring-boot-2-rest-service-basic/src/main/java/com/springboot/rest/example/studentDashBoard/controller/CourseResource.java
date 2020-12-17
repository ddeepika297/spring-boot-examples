package com.springboot.rest.example.studentDashBoard.controller;

import com.springboot.rest.example.studentDashBoard.model.Course;
import com.springboot.rest.example.studentDashBoard.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class CourseResource {

    @Autowired
    private CourseRepo courseRepo;

    @GetMapping("/course/{studentid}")
    public List<Course> retrieveAllCoursesForStudentId(@PathVariable long studentid) throws SQLException {
        return courseRepo.findAllCourse(studentid);
    }
}
