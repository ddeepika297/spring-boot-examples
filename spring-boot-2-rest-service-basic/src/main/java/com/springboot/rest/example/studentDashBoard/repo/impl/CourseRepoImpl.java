package com.springboot.rest.example.studentDashBoard.repo.impl;

import com.springboot.rest.example.studentDashBoard.model.Course;
import com.springboot.rest.example.studentDashBoard.repo.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
@Repository
public class CourseRepoImpl implements CourseRepo {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Course> findAllCourse(long studentId) {
        return jdbcTemplate.query("select * from student_course_Mapping where studentId = ? ", new Object[]{studentId},
                new CourseRowMapper());
    }

    class CourseRowMapper implements RowMapper<Course> {
        @Override
        public Course mapRow(ResultSet rs, int rowNum) throws SQLException {
            Course course = new Course();
            course.setCourseId(rs.getString("courseId"));
            return course;
        }

    }
}
