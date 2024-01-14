package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Controllers.Controllers.CredentialsController;
import com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEditController;
import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import com.example.fxstudentmanagement.Resources.Objects.Credentials;
import com.example.fxstudentmanagement.Resources.Objects.Teacher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEditController.*;
import static com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEditController.stage;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.References.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.References.savedDepartment;

public class CredentialsModel {
    private RegisterOrEditController registerOrEditController;
    private static Teacher teacherObject;
    private com.example.fxstudentmanagement.Resources.Objects.Credentials credentialsObject;

    private CredentialsController credentialsController;

    public void setCredentials(CredentialsController credentialsController) {
        this.credentialsController = credentialsController;
    }

    public void getTeacherInfoAndCreateObject(LocalDate localDate, Integer[] integers, String... strings) {
        if (strings.length == 6)
            teacherObject = new Teacher(strings[0], strings[1], strings[2], strings[3], integers[0], strings[4], localDate, integers[1], integers[2], strings[5]);
        else if (strings.length == 5)
            teacherObject = new Teacher(strings[0], strings[1], strings[2], integers[0], strings[3], localDate, integers[1], integers[2], strings[4]);
    }

    public void checkInputs() throws IOException {
        if (!credentialsController.txtFieldEmail.getText().isEmpty() && !credentialsController.txtFieldPassword.getText().isEmpty() && !credentialsController.txtFieldConfirmPassword.getText().isEmpty()) {
            if (passwordMatched()) {
                if (!emailAlreadyExist()) {
                    proceed();
                } else {
                    alertPasswordMismatch(true);
                }
            } else {
                alertPasswordMismatch(false);
            }
        } else {
            alertFormNotComplete(true, false);
        }
    }

    private boolean passwordMatched() {
        String password = credentialsController.txtFieldPassword.getText();
        String confirmPassword = credentialsController.txtFieldConfirmPassword.getText();

        return password.equals(confirmPassword);
    }

    /*private String hashPassword(String password) {
        try {
            SecureRandom secureRandom = new SecureRandom();
            byte[] salt = new byte[16];
            secureRandom.nextBytes(salt);

            MessageDigest messageDigest = MessageDigest.getInstance("SHA-512");
            messageDigest.update(salt);

            byte[] hashedPassword = messageDigest.digest(password.getBytes(StandardCharsets.UTF_8));
            return Arrays.toString(hashedPassword);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }*/

    private boolean emailAlreadyExist() {
        String email = credentialsController.txtFieldEmail.getText();
        return loginMap.containsKey(email);
    }

    private void proceed() throws IOException{
        String email = credentialsController.txtFieldEmail.getText();
        String password = credentialsController.txtFieldConfirmPassword.getText(); //invoke hashPassword() here

        credentialsObject = new com.example.fxstudentmanagement.Resources.Objects.Credentials(email, password);

        processes();
    }

    private void processes() throws IOException {
        addToLists();
        clearReferences();
        alertRegisterDone();
        toAnotherScene(true);
    }

    private void addToLists() {
        LocalDate localDate = LocalDate.now();
        Teacher teacher = new Teacher("John Jeremie", "Eden", "Male", 17, "09208905313", localDate, 29, 12, "ICT");
        Credentials credentials = new Credentials("admin", "admin");

        teacherSet.add(teacherObject);
        credentialsSet.add(credentialsObject);

        loginMap.put(credentialsController.txtFieldEmail.getText(), credentialsController.txtFieldConfirmPassword.getText());

        credentialsTeacherHashMap.put(credentialsObject, teacherObject);
    }

    private void clearReferences() {
        savedFirstName = null;
        savedMiddleName = null;
        savedLastName = null;
        savedGender = null;
        savedAge = null;
        savedPhoneNumber = null;
        savedBirthday = null;
        savedEmployeeID = null;
        savedGradeLevelTeaching = null;
        savedDepartment = null;
    }

    public void goBack() throws IOException{
        toAnotherScene(false);
    }

    public void toAnotherScene(boolean toLogin) throws IOException{
        String source = toLogin ? Scenes.LOGIN.getPath() : Scenes.REGISTER.getPath(); // IF BABALIK, ISESEND DIN PABALIK YUNG INFOS
        String title = toLogin ? Scenes.LOGIN.getTitle() : Scenes.REGISTER.getTitle();

        fxmlLoader = new FXMLLoader(getClass().getResource(source));
        root = fxmlLoader.load();

        if (!toLogin) {
            registerOrEditController = fxmlLoader.getController();
            registerOrEditController.setFields();
        }

        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();

        closeThisStage();
    }

    private void closeThisStage() {
        Stage thisStage = (Stage) credentialsController.txtFieldEmail.getScene().getWindow();
        thisStage.close();
    }
}
