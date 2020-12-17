package com.springboot.rest.example.studentDashBoard.controller;

import com.springboot.rest.example.studentDashBoard.exception.StudentNotFoundException;
import com.springboot.rest.example.studentDashBoard.model.Student;
import com.springboot.rest.example.studentDashBoard.repo.impl.StudentRepoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@RestController
public class StudentResource {

    @Autowired
    private StudentRepoImpl studentRepository;

    @GetMapping("/students")
    public List<Student> retrieveAllStudents() throws SQLException {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student retrieveStudent(@PathVariable long id) {
        Optional<Student> student = Optional.ofNullable(studentRepository.findById(id));

        if (!student.isPresent())
            throw new StudentNotFoundException("id-" + id);

        return student.get();
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable long id) {
        studentRepository.deleteById(id);
        return ResponseEntity.ok("student deleted successfully");
    }

    @PostMapping("/students")
    public ResponseEntity<Object> createStudent(@RequestBody Student student) {
        studentRepository.save(student);
        return ResponseEntity.ok("created student successfully");
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student, @PathVariable long id) {

        Optional<Student> studentOptional = Optional.ofNullable(studentRepository.findById(id));

        if (!studentOptional.isPresent())
            return ResponseEntity.notFound().build();

        studentRepository.save(student);

        return ResponseEntity.noContent().build();
    }
}
