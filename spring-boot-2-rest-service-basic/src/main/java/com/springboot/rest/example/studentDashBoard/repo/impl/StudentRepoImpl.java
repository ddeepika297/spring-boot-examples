package com.springboot.rest.example.studentDashBoard.repo.impl;

import com.springboot.rest.example.studentDashBoard.model.Student;
import com.springboot.rest.example.studentDashBoard.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentRepoImpl implements StudentRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    class StudentRowMapper implements RowMapper<Student> {
        @Override
        public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
            Student student = new Student();
            student.setStudentId(rs.getLong("studentId"));
            student.setName(rs.getString("name"));
            student.setBranch(rs.getString("branch"));
            student.setSemester(rs.getInt("semester"));
            return student;
        }

    }

    public List<Student> findAll() {
        return jdbcTemplate.query("select * from student", new StudentRowMapper());
    }

    public Student findById(long id) {
        return jdbcTemplate.queryForObject("select * from student where id=?", new Object[]{id},
                new BeanPropertyRowMapper<Student>(Student.class));
    }

    public int deleteById(long id) {
        return jdbcTemplate.update("delete from student where studentId=?", new Object[]{id});
    }

    public int save(Student student) {
        return jdbcTemplate.update("insert into student (studentId, name, branch,semester) " + "values(?,  ?, ?,?)",
                new Object[]{student.getStudentId(), student.getName(), student.getBranch(), student.getSemester()});
    }

    public int update(Student student) {
        return jdbcTemplate.update("update student " + " set name = ?, branch = ?, semesster = ? " + " where studentId = ?",
                new Object[]{student.getName(), student.getBranch(), student.getSemester(), student.getStudentId()});
    }
}
