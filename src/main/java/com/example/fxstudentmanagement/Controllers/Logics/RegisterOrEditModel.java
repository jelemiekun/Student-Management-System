package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEditController;
import com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts;
import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEditController.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;

public class RegisterOrEditModel {
    private String genderSelected;
    private boolean edited;
    public boolean editMode = false;
    private EditProfile editProfile;
    private RegisterOrEditController registerOrEditController;
    public void setRegisterOrEdit(RegisterOrEditController registerOrEditController) {
        this.registerOrEditController = registerOrEditController;
    }
    public void setEditProfile() {
        editProfile = new EditProfile();
    }
    public void btnRegisterClicked() throws IOException{
        checkInputs();
    }
    public void btnGoBackClicked() throws IOException {
        conditionBeforeProceed(false, editMode);
    }
    public void gradeLevelTeachingSelected() {
        Integer gradeLevelSelected = registerOrEditController.choiceBoxGradeLevel.getValue();

        if (gradeLevelSelected != null) {
            if (gradeLevelSelected == 7 || gradeLevelSelected == 8 || gradeLevelSelected == 9 || gradeLevelSelected == 10)
                registerOrEditController.choiceBoxDepartment.setItems(JHSDepartments);
            else if (gradeLevelSelected == 11 || gradeLevelSelected == 12)
                registerOrEditController.choiceBoxDepartment.setItems(SHSDepartments);
        }
    }

    public void setSpinner() {
        int minAge = 1;
        int maxAge = 100;
        registerOrEditController.spinnerAge.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(minAge, maxAge));
        registerOrEditController.spinnerAge.setEditable(true);
    }

    public void getGender() {
        if (registerOrEditController.radioBtnMale.isSelected()) {
            genderSelected = "Male";
        } else if (registerOrEditController.radioBtnFemale.isSelected()) {
            genderSelected = "Female";
        } else if (registerOrEditController.radioBtnOther.isSelected()) {
            genderSelected = "Other";
        }

        if (editMode) {
            System.out.println(genderSelected);
            editProfile.changesMade();
        }
    }

    private void checkInputs() throws IOException{
        if (!registerOrEditController.txtFieldFirstName.getText().isEmpty()     &&   !registerOrEditController.txtFieldLastName.getText().isEmpty() &&
            !registerOrEditController.txtFieldPhoneNumber.getText().isEmpty()   &&   !registerOrEditController.txtFieldEmployeeID.getText().isEmpty() &&
            genderSelected != null         &&   registerOrEditController.spinnerAge.getValue() != null &&
            registerOrEditController.birthday.getValue() != null                &&   registerOrEditController.choiceBoxGradeLevel.getValue() != null &&
            registerOrEditController.choiceBoxDepartment.getValue() != null) {
            if (areInputIntegers()) {
                if (!editMode)
                    conditionBeforeProceed(true, false);
                else
                    editProfile.saveChanges();
            }
        } else {
            alertFormNotComplete(true, false);
        }
    }

    private boolean areInputIntegers() {
        return isPhoneNumberValid() && isEmployeeIDValid();
    }

    private boolean isPhoneNumberValid() {
        try {
            Integer.parseInt(registerOrEditController.txtFieldEmployeeID.getText());
            return true;
        } catch (NumberFormatException e) {
            alertFormNotComplete(false, false);
            return false;
        }
    }

    private boolean isEmployeeIDValid() {
        try {
            String regex = "^\\d{11}$";
            if (registerOrEditController.txtFieldPhoneNumber.getText().matches(regex))
                return true;
            else
                alertFormNotComplete(false, true);
        } catch (NumberFormatException e) {
            alertFormNotComplete(false, true);
            return false;
        }
        return false;
    }

    public void conditionBeforeProceed(boolean toCredentials, boolean toHome) throws IOException{
        if (editMode) {
            System.out.println("conditionBeforePRoceed edited value: " + edited); // PRINT BOOLEAN EDITED VALUE
            if (editProfile.checkIfSomethingChanged())
                proceed(toCredentials,toHome);
        } else {
            proceed(toCredentials, toHome);
        }
    }

    private void proceed(boolean toCredentials, boolean toHome) throws IOException {
        String source = toCredentials ? Scenes.CREDENTIALS.getPath() : toHome ? Scenes.HOME.getPath() : Scenes.LOGIN.getPath();
        String title = toCredentials ? Scenes.CREDENTIALS.getTitle() : toHome ? Scenes.HOME.getTitle(): Scenes.LOGIN.getTitle();

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
        String firstName = registerOrEditController.txtFieldFirstName.getText();
        String lastName = registerOrEditController.txtFieldLastName.getText();
        String gender = genderSelected;
        Integer age = registerOrEditController.spinnerAge.getValue();
        String phoneNumber = registerOrEditController.txtFieldPhoneNumber.getText();
        LocalDate birthday = registerOrEditController.birthday.getValue();
        int employeeID = Integer.parseInt(registerOrEditController.txtFieldEmployeeID.getText());
        Integer gradeLevelTeaching = registerOrEditController.choiceBoxGradeLevel.getValue();
        String department = registerOrEditController.choiceBoxDepartment.getValue();

        CredentialsModel credentialsModel = new CredentialsModel();

        if (!registerOrEditController.txtFieldMiddleName.getText().isEmpty()) {
            String middleName = registerOrEditController.txtFieldMiddleName.getText();
            credentialsModel.getTeacherInfoAndCreateObject(birthday, new Integer[]{age, employeeID, gradeLevelTeaching}, firstName, middleName, lastName, gender, phoneNumber, department);
        } else {
            credentialsModel.getTeacherInfoAndCreateObject(birthday, new Integer[]{age, employeeID, gradeLevelTeaching}, firstName, lastName, gender, phoneNumber, department);
        }
    }

    public class EditProfile {

        public void setProfileFields() {
            setOthers();

            registerOrEditController.txtFieldFirstName.setText(teacherUsing.getFirstName());
            registerOrEditController.txtFieldMiddleName.setText(teacherUsing.getMiddleName());
            registerOrEditController.txtFieldLastName.setText(teacherUsing.getLastName());
            setToggle();
            registerOrEditController.spinnerAge.getValueFactory().setValue(teacherUsing.getAge());
            registerOrEditController.txtFieldPhoneNumber.setText(teacherUsing.getPhoneNumber());
            registerOrEditController.birthday.setValue(teacherUsing.getBirthday());
            registerOrEditController.txtFieldEmployeeID.setText(String.valueOf(teacherUsing.getEmployeeID()));
            registerOrEditController.choiceBoxGradeLevel.setValue(teacherUsing.getGradeLevelTeaching());
            registerOrEditController.choiceBoxDepartment.setValue(teacherUsing.getDepartment());

            setEventReleased();
        }

        private void setOthers() {
            editMode = true;
            registerOrEditController.btnRegister.setText("Edit");
            genderSelected = teacherUsing.getGender();
        }
        private void setToggle() {
            switch (teacherUsing.getGender()) {
                case "Male" -> registerOrEditController.radioBtnMale.setSelected(true);
                case "Female" -> registerOrEditController.radioBtnFemale.setSelected(true);
                case "Other" -> registerOrEditController.radioBtnOther.setSelected(true);
            }
        }

        private void setEventReleased() {
            //registerOrEditController.txtFieldFirstName.setOnKeyReleased(this::changesMade);
            //registerOrEditController.txtFieldMiddleName.setOnKeyReleased(this::changesMade);
            //registerOrEditController.txtFieldLastName.setOnKeyReleased(this::changesMade);
            //registerOrEditController.spinnerAge.setOnKeyReleased(this::changesMade);
            //registerOrEditController.txtFieldPhoneNumber.setOnKeyReleased(this::changesMade);
            registerOrEditController.birthday.setOnAction(this::changesMade);
            //registerOrEditController.txtFieldEmployeeID.setOnKeyReleased(this::changesMade);
            registerOrEditController.choiceBoxGradeLevel.setOnAction(this::changesMade);
            registerOrEditController.choiceBoxDepartment.setOnAction(this::changesMade);
        }

        public void changesMade() {
            edited = true;
        }

        private void changesMade(ActionEvent event) {
            edited = true;
        }

        public boolean checkIfSomethingChanged() {
            if (edited) {
                return Alerts.alertUnsavedChanges();
            } else {
                return true;
            }
        }

        public void saveChanges() {
            if (registerOrEditController.txtFieldMiddleName == null)
                registerOrEditController.txtFieldMiddleName.setText("");

            teacherUsing.setFirstName(registerOrEditController.txtFieldFirstName.getText());
            teacherUsing.setMiddleName(registerOrEditController.txtFieldMiddleName.getText());
            teacherUsing.setLastName(registerOrEditController.txtFieldLastName.getText());
            teacherUsing.setGender(genderSelected == null ? teacherUsing.getGender() : genderSelected);
            teacherUsing.setAge(registerOrEditController.spinnerAge.getValue());
            teacherUsing.setPhoneNumber(registerOrEditController.txtFieldPhoneNumber.getText());
            teacherUsing.setBirthday(registerOrEditController.birthday.getValue());
            teacherUsing.setEmployeeID(Integer.valueOf(registerOrEditController.txtFieldEmployeeID.getText()));
            teacherUsing.setGradeLevelTeaching(registerOrEditController.choiceBoxGradeLevel.getValue());
            teacherUsing.setDepartment(registerOrEditController.choiceBoxDepartment.getValue());

            edited = !edited;
        }
    }

    private void closeThisStage() {
        Stage thisStage = (Stage) registerOrEditController.txtFieldFirstName.getScene().getWindow();
        thisStage.close();
    }
}
