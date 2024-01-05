package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import com.example.fxstudentmanagement.Resources.Objects.Teacher;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

import static com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEdit.*;
import static com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEdit.stage;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;

public class Credentials {
    private static Teacher teacherObject;
    private com.example.fxstudentmanagement.Resources.Objects.Credentials credentialsObject;

    private com.example.fxstudentmanagement.Controllers.Controllers.Credentials credentials;

    public void setCredentials(com.example.fxstudentmanagement.Controllers.Controllers.Credentials credentials) {
        this.credentials = credentials;
    }

    public void getTeacherInfoAndCreateObject(LocalDate localDate, Integer[] integers, String... strings) {
        if (strings.length == 6)
            teacherObject = new Teacher(strings[0], strings[1], strings[2], strings[3], integers[0], strings[4], localDate, integers[1], integers[2], strings[5]);
        else if (strings.length == 5)
            teacherObject = new Teacher(strings[0], strings[1], strings[2], integers[0], strings[3], localDate, integers[1], integers[2], strings[4]);
    }

    public void checkInputs() throws IOException {
        if (!credentials.txtFieldEmail.getText().isEmpty() && !credentials.txtFieldPassword.getText().isEmpty() && !credentials.txtFieldConfirmPassword.getText().isEmpty()) {
            if (passwordMatched()) {
                proceed();
            } else {
                alertPasswordMismatch();
            }
        } else {
            alertFormNotComplete(true, false);
        }
    }

    private boolean passwordMatched() {
        String password = credentials.txtFieldPassword.getText();
        String confirmPassword = credentials.txtFieldConfirmPassword.getText();

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

    private void proceed() throws IOException{
        String email = credentials.txtFieldEmail.getText();
        String password = credentials.txtFieldConfirmPassword.getText(); //invoke hashPassword() here

        credentialsObject = new com.example.fxstudentmanagement.Resources.Objects.Credentials(email, password);

        processes();
    }

    private void processes() throws IOException {
        addToLists();
        alertRegisterDone();
        toAnotherScene(true);
    }

    private void addToLists() {
        teacherSet.add(teacherObject);
        credentialsSet.add(credentialsObject);

        loginMap.put(credentials.txtFieldEmail.getText(), credentials.txtFieldConfirmPassword.getText());

        credentialsTeacherHashMap.put(credentialsObject, teacherObject);
    }

    public void goBack() throws IOException{
        toAnotherScene(false);
    }

    public void toAnotherScene(boolean toLogin) throws IOException{
        String source = toLogin ? Scenes.LOGIN.getPath() : Scenes.REGISTER.getPath(); // IF BABALIK, ISESEND DIN PABALIK YUNG INFOS
        String title = toLogin ? Scenes.LOGIN.getTitle() : Scenes.REGISTER.getTitle();

        fxmlLoader = new FXMLLoader(getClass().getResource(source));
        root = fxmlLoader.load();

        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();

        closeThisStage();
    }

    private void closeThisStage() {
        Stage thisStage = (Stage) credentials.txtFieldEmail.getScene().getWindow();
        thisStage.close();
    }
}
