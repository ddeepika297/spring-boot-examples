package com.springboot.rest.example.studentDashBoard.model;


import java.util.List;

public class Student {

    private Long studentId;
    private String name;
    private int semester;
    private String branch;
   private List<Course> mycourses;
    private List<Exam> myExams;
    public List<Course> getMycourses() {
        return mycourses;
    }

    public void setMycourses(List<Course> mycourses) {
        this.mycourses = mycourses;
    }

    public List<Exam> getMyExams() {
        return myExams;
    }

    public void setMyExams(List<Exam> myExams) {
        this.myExams = myExams;
    }


    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }


    public Student(Long studentId, String name, int semester, String branch) {
        this.studentId = studentId;
        this.name = name;
        this.semester = semester;
        this.branch = branch;
    }


    public Student() {
        super();
    }


}
