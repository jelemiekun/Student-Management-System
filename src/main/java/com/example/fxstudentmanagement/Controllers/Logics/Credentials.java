package com.example.fxstudentmanagement.Controllers.Logics;

import javafx.stage.Stage;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.Arrays;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;

public class Credentials {
    private com.example.fxstudentmanagement.Controllers.Controllers.Credentials credentials;

    public void setCredentials(com.example.fxstudentmanagement.Controllers.Controllers.Credentials credentials) {
        this.credentials = credentials;
    }

    public void checkInputs() throws IOException {
        if (!credentials.txtFieldEmail.getText().isEmpty() && !credentials.txtFieldPassword.getText().isEmpty() && !credentials.txtFieldConfirmPassword.getText().isEmpty()) {
            if (passwordMatched()) {
                proceed();
            } else {
                alertPasswordMismatch();
            }
        } else {
            alertFormNotComplete(true);
        }
    }

    private void proceed() throws IOException {
        String email = credentials.txtFieldEmail.getText();
        String password = credentials.txtFieldConfirmPassword.getText();

        RegisterOrEdit registerOrEdit = new RegisterOrEdit();

        registerOrEdit.credentials = new com.example.fxstudentmanagement.Resources.Objects.Credentials(email, password);

        closeThisStage();
        registerOrEdit.doneAdding();
    }

    private boolean passwordMatched() {
        String password = credentials.txtFieldPassword.getText();
        String confirmPassword = credentials.txtFieldConfirmPassword.getText();

        return password.equals(confirmPassword);
    }

    private String hashPassword() {
        try {
            String password = credentials.txtFieldConfirmPassword.getText();

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
    }

    private void closeThisStage() throws IOException{
        Stage thisStage = (Stage) credentials.txtFieldEmail.getScene().getWindow();
        thisStage.close();
    }

    private void createAccount(LocalDate localDate, Integer[] integers, String... strings) {

    }

    public void goBack() {

    }
}
