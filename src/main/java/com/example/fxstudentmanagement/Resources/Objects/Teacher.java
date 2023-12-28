package com.example.fxstudentmanagement.Resources.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Optional;
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

    public void importSection() {

    }
    public void exportSection() {

    }

    public void addSection() {
        /**
         * DITO NARIN MAMIMILI NG GRADE LEVEL AT STRAND
         */
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Customized Text Input Dialog");
        dialog.setHeaderText("Enter your name:");
        dialog.setContentText("Name:");

        // Create custom buttons
        ButtonType buttonTypeYes = new ButtonType("Yes", ButtonBar.ButtonData.OK_DONE);
        ButtonType buttonTypeNo = new ButtonType("No", ButtonBar.ButtonData.CANCEL_CLOSE);

        // Set custom buttons to the dialog
        dialog.getDialogPane().getButtonTypes().setAll(buttonTypeYes, buttonTypeNo);

        // Show the dialog
        Optional<String> result = dialog.showAndWait();

        // Handle the result
        result.ifPresent(name -> System.out.println(name));
    }
    public void viewSection() {

    }
    public void updateSection() {

    }
    public void deleteSection() {

    }
}
