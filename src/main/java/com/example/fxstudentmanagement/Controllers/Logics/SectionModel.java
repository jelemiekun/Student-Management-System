package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Controllers.Controllers.SectionController;
import com.example.fxstudentmanagement.Resources.Objects.Student;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;

import java.time.LocalDate;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.selectedSection;

public class SectionModel {
    private SectionController sectionController;

    public void setSectionController(SectionController sectionController) {
        this.sectionController = sectionController;
    }

    public void initialize() {
        sectionController.tableView.setItems(selectedSection.studentObservableList);
        sectionController.colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        sectionController.colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        sectionController.colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        sectionController.colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        sectionController.colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        sectionController.colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        sectionController.colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        sectionController.colBirthdate.setCellValueFactory(new PropertyValueFactory<>("birthday"));

        sectionController.labelSection.setText(selectedSection.getSectionName());
    }

    public void setSpinner() {
        int minAge = 1;
        int maxAge = 100;
        sectionController.spinnerAge.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minAge, maxAge));
        sectionController.spinnerAge.setEditable(true);
    }

    public void addStudent() {
        if (!areSectionInfoEdited()) {
            if (!areFieldsEmpty()) {
                addNewStudent();
            } else {
                alertSection(false);
            }
        } else {
            alertSection(true);
        }
    }

    private boolean areSectionInfoEdited() {
        return sectionController.labelSection.getText().contains("Section") && sectionController.labelGradeLevel.getText().contains("GRD LVL") &&
                sectionController.labelStrand.getText().contains("STRANDHERE");
    }

    private boolean areFieldsEmpty() {
        return sectionController.txtFieldStudentID.getText().isEmpty() && sectionController.txtFieldLastName.getText().isEmpty() &&
                sectionController.txtFieldFirstName.getText().isEmpty() && sectionController.selectedGender == null &&
                sectionController.selectedAge == null && sectionController.txtFieldPhoneNumber.getText().isEmpty() && sectionController.selectedBirthdate == null;
    }


    //sectionController.txtFieldFirstName.getText().isBlank() &&)
    private void addNewStudent() {
        String firstName = sectionController.txtFieldFirstName.getText();
        String middleName = sectionController.txtFieldMiddleName.getText();
        String lastName = sectionController.txtFieldLastName.getText();
        String gender = sectionController.selectedGender;
        Integer age = sectionController.selectedAge;
        String phoneNumber = sectionController.txtFieldPhoneNumber.getText();
        LocalDate birthday = sectionController.selectedBirthdate;
        Integer studentID = Integer.valueOf(sectionController.txtFieldStudentID.getText());
        Integer gradeLevel = Integer.valueOf(sectionController.labelGradeLevel.getText());
        String strand = sectionController.labelStrand.getText();
        String section = sectionController.labelSection.getText();

        Student student;
        if (middleName.isEmpty())
            student = new Student(firstName, lastName, gender, age, phoneNumber, birthday, studentID, gradeLevel, strand, section);
        else
            student = new Student(firstName, middleName, lastName, gender, age, phoneNumber, birthday, studentID, gradeLevel, strand, section);

        selectedSection.studentObservableList.add(student);
    }
}
