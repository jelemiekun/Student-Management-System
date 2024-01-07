package com.example.fxstudentmanagement.Resources.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.teacherUsing;

public class Section {
    public ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
    private Integer sectionNumber;
    private String sectionName;
    private String adviserName;
    private Integer sectionStudentCount;
    public Section() {
        teacherUsing.addSection();
        this.sectionNumber = teacherUsing.getNumberOfSections();
        this.sectionName = "Section " + sectionNumber;
        this.adviserName = "";
    }

    public Integer getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(Integer sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }

    public String getAdviserName() {
        return adviserName;
    }

    public void setAdviserName(String adviserName) {
        this.adviserName = adviserName;
    }

    public Integer getSectionStudentCount() {
        return sectionStudentCount;
    }

    public void setSectionStudentCount(Integer sectionStudentCount) {
        this.sectionStudentCount = sectionStudentCount;
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
