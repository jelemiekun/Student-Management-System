package com.example.fxstudentmanagement.Resources.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.time.LocalDate;

public class Teacher extends Person {
    public ObservableList<Section> sectionObservableList = FXCollections.observableArrayList();
    private Integer numberOfSections = 0;
    private Integer employeeID;
    private Integer gradeLevelTeaching;
    private String department;

    public Teacher(String firstName, String middleName, String lastName, String gender, Integer age, String phoneNumber, LocalDate birthday,
                   Integer employeeID, Integer gradeLevelTeaching, String department) {
        super(firstName, middleName, lastName, gender, age, phoneNumber, birthday);
        this.employeeID = employeeID;
        this.gradeLevelTeaching = gradeLevelTeaching;
        this.department = department;
    }

    public Teacher(String firstName, String lastName, String gender, Integer age, String phoneNumber, LocalDate birthday,
                   Integer employeeID, Integer gradeLevelTeaching, String department) {
        super(firstName, lastName, gender, age, phoneNumber, birthday);
        this.employeeID = employeeID;
        this.gradeLevelTeaching = gradeLevelTeaching;
        this.department = department;
    }

    public void addSection() {
        numberOfSections++;
    }

    public Integer getNumberOfSections() {
        return numberOfSections;
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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
