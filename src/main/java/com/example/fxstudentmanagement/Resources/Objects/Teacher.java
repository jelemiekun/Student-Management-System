package com.example.fxstudentmanagement.Resources.Objects;

import java.time.LocalDate;

public class Teacher extends Person{
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
}
