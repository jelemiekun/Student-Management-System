package com.example.fxstudentmanagement.Resources.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Scanner;

public class Teacher extends Person implements TeacherOperation {
    private Integer employeeID;
    private Integer gradeLevelTeaching;
    private String subject;

    public Teacher(String firstName, String middleName, String lastName, String gender, Integer age, String phoneNumber, LocalDate birthday,
                   Integer employeeID, Integer gradeLevelTeaching, String subject) {
        super(firstName, middleName, lastName, gender, age, phoneNumber, birthday);
        this.employeeID = employeeID;
        this.gradeLevelTeaching = gradeLevelTeaching;
        this.subject = subject;
    }

    public Teacher(String firstName, String lastName, String gender, Integer age, String phoneNumber, LocalDate birthday,
                   Integer employeeID, Integer gradeLevelTeaching, String subject) {
        super(firstName, lastName, gender, age, phoneNumber, birthday);
        this.employeeID = employeeID;
        this.gradeLevelTeaching = gradeLevelTeaching;
        this.subject = subject;
    }

    public Integer getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Integer employeeID) {
        this.employeeID = employeeID;
    }

    public Integer getGradeLevelTeaching() {
        return gradeLevelTeaching;
    }

    public void setGradeLevelTeaching(Integer gradeLevelTeaching) {
        this.gradeLevelTeaching = gradeLevelTeaching;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    // Operations
    private static Integer numberOfSections;
    public ObservableList<Section> sectionObservableList = FXCollections.observableArrayList();
    public Section section;

    public void viewSectionList() {

    }

    public void clearSection() {

    }

    public void importSection() {

    }
    public void exportSection() {

    }

    public void addSection() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Section name:");
        String sectionName = scanner.nextLine();

        section = new Section(sectionName);
        sectionObservableList.add(section);
        System.out.println("Section " + sectionName + " created");
    }
    public void updateSection() {

    }
    public void deleteSection() {

    }
}
