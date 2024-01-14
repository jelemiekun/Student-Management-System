package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Controllers.Controllers.SectionController;
import com.example.fxstudentmanagement.Resources.Objects.Student;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;

public class SectionModel {
    private boolean editMode = true;
    private SectionController sectionController;

    public void setSectionController(SectionController sectionController) {
        this.sectionController = sectionController;
    }

    public void initialize() {
        initializeLabels();
        initializeTable();
        setSpinner();
        initializeChoiceBox();
        initializeDepartmentChoiceBox();

        if (selectedSection.isEdited()) {
            editSection();
            initializeComboBoxes();
        }
    }

    private void initializeLabels() {
        sectionController.labelSection.setText(selectedSection.getSectionName());
        sectionController.labelGradeLevel.setText(String.valueOf(selectedSection.getSectionGradeLevel()));
        sectionController.labelLevelStrand.setText(selectedSection.getSectionGradeLevel() + " - " + selectedSection.getSectionStrand());
    }

    private void initializeTable() {
        sectionController.tableView.setItems(selectedSection.studentObservableList);
        sectionController.colStudentID.setCellValueFactory(new PropertyValueFactory<>("studentID"));
        sectionController.colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        sectionController.colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        sectionController.colMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        sectionController.colGender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        sectionController.colAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        sectionController.colPhoneNumber.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        sectionController.colBirthdate.setCellValueFactory(new PropertyValueFactory<>("birthday"));
    }

    private void initializeChoiceBox() {
        sectionController.comboBoxGradeLevel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            changeStrandChoiceBox();
        });

        sectionController.comboBoxStrand.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            changeSectionChoiceBox();
        });
    }

    private void initializeDepartmentChoiceBox() {
        Set<String> allDepartments = new HashSet<>();
        allDepartments.addAll(JHSDepartments);
        allDepartments.addAll(SHSDepartments);

        ObservableList<String> departmentsObservableList = FXCollections.observableArrayList();
        departmentsObservableList.addAll(allDepartments);

        sectionController.comboBoxDepartment.setItems(departmentsObservableList);
    }

    public void setGender() {
        if (sectionController.radioBtnMale.isSelected())
            sectionController.selectedGender = "Male";
        else if (sectionController.radioBtnFemale.isSelected())
            sectionController.selectedGender = "Female";
    }

    private void setSpinner() {
        int minAge = 1;
        int maxAge = 100;
        sectionController.spinnerAge.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minAge, maxAge));
        sectionController.spinnerAge.setEditable(true);
        sectionController.spinnerAge.valueProperty().addListener(new ChangeListener<Integer>() {
            @Override
            public void changed(ObservableValue<? extends Integer> observableValue, Integer integer, Integer t1) {
                sectionController.selectedAge = t1;
            }
        });
    }

    private void changeStrandChoiceBox() {
        Integer gradeLevelSelected = sectionController.comboBoxGradeLevel.getValue();

        if (gradeLevelSelected != null) {
            if (gradeLevelSelected == 7 || gradeLevelSelected == 8 || gradeLevelSelected == 9 || gradeLevelSelected == 10)
                sectionController.comboBoxStrand.setItems(JHSStrands);
            else if (gradeLevelSelected == 11 || gradeLevelSelected == 12)
                sectionController.comboBoxStrand.setItems(SHSStrands);

            sectionController.comboBoxStrand.getSelectionModel().clearSelection();
            sectionController.comboBoxSection.getSelectionModel().clearSelection();
        }
    }

    private void changeSectionChoiceBox() {
        String strand = sectionController.comboBoxStrand.getValue();

        if (strand != null) {
            switch (strand) {
                case "STE":
                    sectionController.comboBoxSection.setItems(steObservableList);
                    break;
                case "EBEC":
                    sectionController.comboBoxSection.setItems(ebecObservableList);
                    break;
                case "SPS":
                    sectionController.comboBoxSection.setItems(spsObservableList);
                    break;
                case "SPA":
                    sectionController.comboBoxSection.setItems(spaObservableList);
                    break;
                case "ABM":
                    sectionController.comboBoxSection.setItems(ABMobservableList);
                    break;
                case "A.D.":
                    sectionController.comboBoxSection.setItems(ADobservableList);
                    break;
                case "HE 3":
                    sectionController.comboBoxSection.setItems(HE3observableList);
                    break;
                case "HE 4":
                    sectionController.comboBoxSection.setItems(HE4observableList);
                    break;
                case "HUMSS":
                    sectionController.comboBoxSection.setItems(HUMSSobservableList);
                    break;
                case "IA":
                    sectionController.comboBoxSection.setItems(IAobservableList);
                    break;
                case "ICT Programming":
                    sectionController.comboBoxSection.setItems(ICTCOMPPROGobservableList);
                    break;
                case "ICT CSS":
                    sectionController.comboBoxSection.setItems(ICTCSSobservableList);
                    break;
                case "SPORTS":
                    sectionController.comboBoxSection.setItems(SPORTSobservableList);
                    break;
                case "STEM":
                    sectionController.comboBoxSection.setItems(STEMobservableList);
                    break;
            }
        }
    }

    public void addStudent() {
        if (!areSectionInfoEdited()) {
            if (!areFieldsEmpty()) {
                if(areIntegersValid()) {
                    addNewStudent();
                }
            } else {
                alertSection(false);
            }
        } else {
            alertSection(true);
        }
    }

    private boolean areIntegersValid() {
        return isPhoneNumberValid() && isStudentIDValid();
    }

    private boolean isStudentIDValid() {
        String input = sectionController.txtFieldStudentID.getText();

        if (input != null && input.matches("\\d+")) {
            return input.length() == 2;
        } else {
            System.out.println("Invalid student ID");
            return false;
        }
    }

    private boolean isPhoneNumberValid() {
        try {
            String regex = "^\\d{11}$";
            return sectionController.txtFieldPhoneNumber.getText().matches(regex);
        } catch (NumberFormatException e) {
            alertFormNotComplete(false, true);
            return false;
        }
    }

    private boolean areSectionInfoEdited() {
        return sectionController.labelSection.getText().contains("Section") && sectionController.labelGradeLevel.getText().contains("GRD LVL") &&
                sectionController.labelStrand.getText().contains("STRANDHERE");
    }

    private boolean areFieldsEmpty() {

        return sectionController.txtFieldStudentID.getText().isEmpty() || sectionController.txtFieldLastName.getText().isEmpty() ||
                sectionController.txtFieldFirstName.getText().isEmpty() || sectionController.selectedGender == null ||
                sectionController.selectedAge == null || sectionController.txtFieldPhoneNumber.getText().isEmpty() || sectionController.selectedBirthdate == null;
    }

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

    public void editSectionInfo() {
        if (!areChoiceBoxSelected()) {
            editSection();
            saveChanges();
        } else {
            alertSection(true);
        }
    }

    private void editSection() {
        editMode = !editMode;
        sectionController.comboBoxGradeLevel.setVisible(editMode);
        sectionController.comboBoxStrand.setVisible(editMode);
        sectionController.comboBoxSection.setVisible(editMode);
        sectionController.comboBoxDepartment.setVisible(editMode);
        sectionController.txtFieldTeacher.setVisible(editMode);
        sectionController.btnEditSection.setText(editMode ? "Save Changes" : "Edit Section Info");
    }

    private boolean areChoiceBoxSelected() {
        return sectionController.comboBoxGradeLevel.getValue() == null || sectionController.comboBoxStrand.getValue() == null ||
                sectionController.comboBoxSection.getValue() == null;
    }

    private void initializeComboBoxes() {
        sectionController.comboBoxGradeLevel.setValue(selectedSection.getSectionGradeLevel());
        sectionController.comboBoxStrand.setValue(selectedSection.getSectionStrand());
        sectionController.comboBoxSection.setValue(selectedSection.getSectionName());
    }

    private void saveChanges() {
        if (sectionController.btnEditSection.getText().equals("Edit Section Info")) {
            Integer gradeLevel = sectionController.comboBoxGradeLevel.getValue();
            String strand = sectionController.comboBoxStrand.getValue();
            String sectionName = sectionController.comboBoxSection.getValue();

            selectedSection.setSectionGradeLevel(gradeLevel);
            selectedSection.setSectionStrand(strand);
            selectedSection.setSectionName(sectionName);

            initializeLabels();
            selectedSection.setEdited(true);
        }
    }

    public void deleteSection() {
        if (alertReturnBoolean(false, true, selectedSection.getSectionName())) {
            teacherUsing.sectionObservableList.remove(selectedSection);
            closeThisStage();
        }
    }

    public void closeThisStage() {
        Stage thisStage = (Stage) sectionController.labelSection.getScene().getWindow();
        thisStage.close();
    }
}