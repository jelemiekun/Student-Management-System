package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts;
import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import com.example.fxstudentmanagement.Resources.Objects.Credentials;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.example.fxstudentmanagement.Controllers.Controllers.LoginController.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;

import java.io.IOException;

public class LoginModel {
    private static Integer attemptCount = 1;
    private static Integer MAX_ATTEMPTS = 5;
    private com.example.fxstudentmanagement.Controllers.Controllers.LoginController loginController;

    public void setLogin(com.example.fxstudentmanagement.Controllers.Controllers.LoginController loginController) {
        this.loginController = loginController;
    }
    public void proceed(boolean isHome) throws IOException {
        if (isHome) {
            if (!doesMaxAttemptReached()) {
                if (attemptLogin()) {
                    proceedToLoginProcesses();
                }
            } else {
                attemptLimitReached();
            }
        } else {
            goToAnotherScene(false);
            closeThisStage();
        }
    }

    private void proceedToLoginProcesses() throws IOException {
        getKeyAndValueCredentialsTeacher();
        goToAnotherScene(true);
        closeThisStage();
    }

    private void goToAnotherScene(boolean toHome) throws IOException {
        String resource = toHome ? Scenes.HOME.getPath() : Scenes.REGISTER.getPath();
        String title = toHome? Scenes.HOME.getTitle() : Scenes.REGISTER.getTitle();

        fxmlLoader = new FXMLLoader(LoginModel.class.getResource(resource));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();
    }

    private boolean doesMaxAttemptReached() {
        return attemptCount.equals(MAX_ATTEMPTS);
    }

    private boolean attemptLogin() {
        if (checkInputs()) {
            if (checkInList()) {
                return true;
            } else {
                attemptCount++;
            }
        }
        return false;
    }

    private boolean checkInputs() {
        return (!loginController.txtFieldEmail.getText().isEmpty() && !loginController.txtFieldPassword.getText().isEmpty());
    }

    private boolean checkInList() {
        String email = loginController.txtFieldEmail.getText();
        String password = loginController.txtFieldPassword.getText();

        if (loginMap.containsKey(email)) {
            if (loginMap.containsValue(password)) { // successfully logged in
                return true;
            } else {
                Alerts.alertLoginAttempt(true, false);
            }
        } else {
            Alerts.alertLoginAttempt(false, false);
        }
        return false;
    }

    private void getKeyAndValueCredentialsTeacher() { // get key of credentials from email and get value of teacher from key of credentials
        getCredentialsValue();
        getTeacherKey();
    }

    private void getCredentialsValue() {
        String email = loginController.txtFieldEmail.getText();

        for (Credentials credentialsLogin : credentialsSet) {
            if (credentialsLogin.getEmail().equals(email)) {
                credentialsUsing = credentialsLogin;
                return;
            }
        }
    }

    private void getTeacherKey() {
        teacherUsing = credentialsTeacherHashMap.get(credentialsUsing);
    }

    public void viewPass() {
        if (loginController.checkViewPass.isSelected()) {
            loginController.txtFieldPassword.setVisible(false);
            loginController.txtFieldViewPass.setVisible(true);
            loginController.txtFieldViewPass.setText(loginController.txtFieldPassword.getText());
        } else {
            loginController.txtFieldPassword.setVisible(true);
            loginController.txtFieldViewPass.setVisible(false);
            loginController.txtFieldPassword.setText(loginController.txtFieldViewPass.getText());
        }
    }

    private void attemptLimitReached() {
        Alerts.alertLoginAttempt(true, true);
        loginController.txtFieldEmail.setText(null);
        loginController.txtFieldPassword.setText(null);
        attemptCount = 1;
        loginController.txtFieldEmail.requestFocus();
    }

    private void closeThisStage() {
        Stage loginStage = (Stage) loginController.txtFieldEmail.getScene().getWindow();
        loginStage.close();
    }
}
