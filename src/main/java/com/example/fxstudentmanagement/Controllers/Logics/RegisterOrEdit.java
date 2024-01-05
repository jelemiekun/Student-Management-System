package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEdit.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;

public class RegisterOrEdit {
    private String genderSelected;
    private com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEdit registerOrEdit;
    public void setRegisterOrEdit(com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEdit registerOrEdit) {
        this.registerOrEdit = registerOrEdit;
    }
    public void btnRegisterClicked() throws IOException{
        checkInputs();
    }
    public void gradeLevelTeachingSelected() {
        Integer gradeLevelSelected = registerOrEdit.choiceBoxGradeLevel.getValue();

        if (gradeLevelSelected != null) {
            if (gradeLevelSelected == 7 || gradeLevelSelected == 8 || gradeLevelSelected == 9 || gradeLevelSelected == 10)
                registerOrEdit.choiceBoxDepartment.setItems(JHSDepartments);
            else if (gradeLevelSelected == 11 || gradeLevelSelected == 12)
                registerOrEdit.choiceBoxDepartment.setItems(SHSDepartments);
        }
    }

    public void setSpinner() {
        int minAge = 1;
        int maxAge = 100;
        registerOrEdit.spinnerAge.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minAge, maxAge));
        registerOrEdit.spinnerAge.setEditable(true);
    }

    public void getGender() {
        if (registerOrEdit.radioBtnMale.isSelected()) {
            genderSelected = "Male";
        } else if (registerOrEdit.radioBtnFemale.isSelected()) {
            genderSelected = "Female";
        } else if (registerOrEdit.radioBtnOther.isSelected()) {
            genderSelected = "Other";
        }
    }

    private void checkInputs() throws IOException{
        if (!registerOrEdit.txtFieldFirstName.getText().isEmpty()     &&   !registerOrEdit.txtFieldLastName.getText().isEmpty() &&
            !registerOrEdit.txtFieldPhoneNumber.getText().isEmpty()   &&   !registerOrEdit.txtFieldEmployeeID.getText().isEmpty() &&
            registerOrEdit.gender.getSelectedToggle() != null         &&   registerOrEdit.spinnerAge.getValue() != null &&
            registerOrEdit.birthday.getValue() != null                &&   registerOrEdit.choiceBoxGradeLevel.getValue() != null &&
            registerOrEdit.choiceBoxDepartment.getValue() != null) {
            if (areInputIntegers()) {
                proceed(true);
            }
             //   alertFormNotComplete(false);
        } else {
            alertFormNotComplete(true, false);
        }
    }

    private boolean areInputIntegers() {
        return isPhoneNumberValid() && isEmployeeIDValid();
    }

    private boolean isPhoneNumberValid() {
        try {
            Integer.parseInt(registerOrEdit.txtFieldEmployeeID.getText());
            return true;
        } catch (NumberFormatException e) {
            alertFormNotComplete(false, false);
            return false;
        }
    }

    private boolean isEmployeeIDValid() {
        try {
            String regex = "^\\d{11}$";
            return registerOrEdit.txtFieldPhoneNumber.getText().matches(regex);
        } catch (NumberFormatException e) {
            alertFormNotComplete(false, true);
            return false;
        }
    }

    public void proceed(boolean toCredentials) throws IOException{
        String source = toCredentials ? Scenes.CREDENTIALS.getPath() : Scenes.LOGIN.getPath();
        String title = toCredentials ? Scenes.CREDENTIALS.getTitle() : Scenes.LOGIN.getTitle();

        fxmlLoader = new FXMLLoader(getClass().getResource(source));
        root = fxmlLoader.load();

        if (toCredentials)
            addTeacher();

        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();

        closeThisStage();
    }

    private void addTeacher() {
        String firstName = registerOrEdit.txtFieldFirstName.getText();
        String lastName = registerOrEdit.txtFieldLastName.getText();
        String gender = genderSelected;
        Integer age = registerOrEdit.spinnerAge.getValue();
        String phoneNumber = registerOrEdit.txtFieldPhoneNumber.getText();
        LocalDate birthday = registerOrEdit.birthday.getValue();
        int employeeID = Integer.parseInt(registerOrEdit.txtFieldEmployeeID.getText());
        Integer gradeLevelTeaching = registerOrEdit.choiceBoxGradeLevel.getValue();
        String department = registerOrEdit.choiceBoxDepartment.getValue();

        Credentials credentials = new Credentials();

        if (!registerOrEdit.txtFieldMiddleName.getText().isEmpty()) {
            String middleName = registerOrEdit.txtFieldMiddleName.getText();
            credentials.getTeacherInfoAndCreateObject(birthday, new Integer[]{age, employeeID, gradeLevelTeaching}, firstName, middleName, lastName, gender, phoneNumber, department);
        } else {
            credentials.getTeacherInfoAndCreateObject(birthday, new Integer[]{age, employeeID, gradeLevelTeaching}, firstName, lastName, gender, phoneNumber, department);
        }

    }

    private void closeThisStage() {
        Stage thisStage = (Stage) registerOrEdit.txtFieldFirstName.getScene().getWindow();
        thisStage.close();
    }
}
