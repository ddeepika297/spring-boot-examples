package com.springboot.rest.example.studentDashBoard.repo;

import com.springboot.rest.example.studentDashBoard.model.Course;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo {
    public List<Course> findAllCourse(long studentid) ;
}
