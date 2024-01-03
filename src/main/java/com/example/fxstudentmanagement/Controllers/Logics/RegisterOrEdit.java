package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Resources.Objects.Credentials;
import com.example.fxstudentmanagement.Resources.Objects.Teacher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;

import static com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEdit.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;

public class RegisterOrEdit {
    public Credentials credentials;
    private Teacher teacher;
    private String genderSelected;
    private com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEdit registerOrEdit;
    public void setRegisterOrEdit(com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEdit registerOrEdit) {
        this.registerOrEdit = registerOrEdit;
    }
    public void btnRegisterClicked() throws IOException{
        System.out.println(loginHashMap);
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
                addTeacher();
            } else {
                alertFormNotComplete(false);
            }
        } else {
            alertFormNotComplete(true);
        }
    }

    private boolean areInputIntegers() {
        try {
            Integer intValue = Integer.parseInt(registerOrEdit.txtFieldEmployeeID.getText());
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void addTeacher() throws IOException{
        String firstName = registerOrEdit.txtFieldFirstName.getText();
        String lastName = registerOrEdit.txtFieldLastName.getText();
        String gender = genderSelected;
        Integer age = registerOrEdit.spinnerAge.getValue();
        String phoneNumber = registerOrEdit.txtFieldPhoneNumber.getText();
        LocalDate birthday = registerOrEdit.birthday.getValue();
        Integer employeeID = Integer.valueOf(registerOrEdit.txtFieldEmployeeID.getText());
        Integer gradeLevelTeaching = registerOrEdit.choiceBoxGradeLevel.getValue();
        String department = registerOrEdit.choiceBoxDepartment.getValue();

        Teacher teacher1;
        if (registerOrEdit.txtFieldMiddleName.getText().isEmpty()) {
            teacher1 = new Teacher(firstName, lastName, gender, age, phoneNumber, birthday, employeeID, gradeLevelTeaching, department);
        } else {
            String middleName = registerOrEdit.txtFieldMiddleName.getText();
            teacher1 = new Teacher(firstName, middleName, lastName, gender, age, phoneNumber, birthday, employeeID, gradeLevelTeaching, department);
        }

        teacher = teacher1;
        System.out.println(teacher);
        credentials();
    }

    private void credentials() throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/fxstudentmanagement/Credentials.fxml"));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("Credentials");
        stage.show();

        closeThisStage(true);
    }

    public void doneAdding() throws IOException{
        addToLists();
        alertRegisterDone();
        proceed(true);
    }

    private void addToLists() {
        loginHashMap.put(credentials, teacher);
        teacherHashSet.add(teacher);

        System.out.println(loginHashMap);
    }

    public void proceed(boolean toLogin) throws IOException{
        String source = toLogin ? "/com/example/fxstudentmanagement/Login.fxml" : "/com/example/fxstudentmanagement/Home.fxml";
        String title = toLogin ? "Log-in" : "Home";

        fxmlLoader = new FXMLLoader(getClass().getResource(source));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();

        closeThisStage(false);
    }

    private void closeThisStage(boolean isHide) throws IOException{
        Stage thisStage = (Stage) registerOrEdit.txtFieldFirstName.getScene().getWindow();
        if (isHide)
            thisStage.hide();
        else
            thisStage.close();
    }
}
