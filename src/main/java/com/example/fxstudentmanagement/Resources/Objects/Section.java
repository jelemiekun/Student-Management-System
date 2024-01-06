package com.example.fxstudentmanagement.Resources.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Section {
    private static Integer numberOfSections;
    public ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
    private Integer sectionID;
    private String sectionName;
    private String adviserName;
    private Integer sectionCount;
    public Section(String sectionName, String adviserName) {
        // generate section id ->
        this.sectionName = sectionName;
        this.adviserName = adviserName;
    }

    public Section(String sectionName) {
        // generate section id -> sectionID = generateSectionID();
        this.sectionName = sectionName;
    }

    public void addStudent(Student student) {
        studentObservableList.add(student);
        System.out.println(student.getFirstName() + " added!");
    }
    public void updateStudent(Student student) {

    }
    public void removeStudent(Student student) {

    }

    public void viewClassList() {

    }

    public void viewStudentGrades() {

    }
    public void calculateSectionAverage() {

    }
}
