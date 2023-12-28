package com.example.fxstudentmanagement.Resources.Objects;

import java.time.LocalDate;

public class Student extends Person {
    private Integer studentID;
    private Integer gradeLevel;
    private String strand;
    private String section;
    public Student(String firstName, String middleName, String lastName, String gender, Integer age, String phoneNumber, LocalDate birthday,
                   Integer studentID, Integer gradeLevel, String strand, String section) {
        super(firstName, middleName, lastName, gender, age, phoneNumber, birthday);
        this.studentID = studentID;
        this.gradeLevel = gradeLevel;
        this.strand = strand;
        this.section = section;
    }

    public Student(String firstName, String lastName, String gender, Integer age, String phoneNumber, LocalDate birthday,
                   Integer studentID, Integer gradeLevel, String strand, String section) {
        super(firstName, lastName, gender, age, phoneNumber, birthday);
        this.studentID = studentID;
        this.gradeLevel = gradeLevel;
        this.strand = strand;
        this.section = section;
    }

    public Integer getStudentID() {
        return studentID;
    }

    public void setStudentID(Integer studentID) {
        this.studentID = studentID;
    }

    public Integer getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(Integer gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getStrand() {
        return strand;
    }

    public void setStrand(String strand) {
        this.strand = strand;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }
}
