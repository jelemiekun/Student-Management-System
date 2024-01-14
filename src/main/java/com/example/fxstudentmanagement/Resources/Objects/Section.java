package com.example.fxstudentmanagement.Resources.Objects;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.References.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.util.HashSet;
import java.util.Set;


public class Section {
    public ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
    public Set<Integer> studentIDObservableList = new HashSet<>();
    private Integer sectionNumber;
    private Integer sectionGradeLevel;
    private String sectionStrand;
    private String sectionName;
    private String adviserName;
    private String adviserDepartment;
    private Integer sectionStudentCount;
    private boolean edited;
    public Section() {
        selectedTeacher.addSection();
        this.sectionNumber = selectedTeacher.getNumberOfSections();
        this.sectionName = "Section " + sectionNumber;
        this.sectionStudentCount = 0;
    }

    public Integer getSectionNumber() {
        return sectionNumber;
    }

    public void setSectionNumber(Integer sectionNumber) {
        this.sectionNumber = sectionNumber;
    }

    public Integer getSectionGradeLevel() {
        return sectionGradeLevel;
    }

    public void setSectionGradeLevel(Integer sectionGradeLevel) {
        this.sectionGradeLevel = sectionGradeLevel;
    }

    public String getSectionStrand() {
        return sectionStrand;
    }

    public void setSectionStrand(String sectionStrand) {
        this.sectionStrand = sectionStrand;
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

    public String getAdviserDepartment() {
        return adviserDepartment;
    }

    public void setAdviserDepartment(String adviserDepartment) {
        this.adviserDepartment = adviserDepartment;
    }

    public Integer getSectionStudentCount() {
        return sectionStudentCount;
    }

    public void addSectionStudentCount() {
        sectionStudentCount++;
    }

    public void minusSectionStudentCount() {
        sectionStudentCount--;
    }

    public boolean isEdited() {
        return edited;
    }

    public void setEdited(boolean edited) {
        this.edited = edited;
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
