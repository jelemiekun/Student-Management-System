package com.example.fxstudentmanagement.Resources.Objects;

import java.time.LocalDate;

public abstract class Person {
    protected String firstName;
    protected String middleName;
    protected String lastName;
    protected String gender;
    protected Integer age;
    protected String phoneNumber;
    protected LocalDate birthday;
    protected Person(String firstName, String middleName, String lastName, String gender, Integer age, String phoneNumber, LocalDate birthday) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    protected Person(String firstName, String lastName, String gender, Integer age, String phoneNumber, LocalDate birthday) {
        this.firstName = firstName;
        this.middleName = "N/A";
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getGender() {
        return gender;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
}
