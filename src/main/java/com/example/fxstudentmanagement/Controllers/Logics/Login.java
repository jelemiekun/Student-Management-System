package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts;
import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.example.fxstudentmanagement.Controllers.Controllers.Login.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.loginHashMap;

import java.io.IOException;

public class Login {
    private static Integer attemptCount = 1;
    private static Integer MAX_ATTEMPTS = 5;
    private com.example.fxstudentmanagement.Controllers.Controllers.Login login;

    public void setLogin(com.example.fxstudentmanagement.Controllers.Controllers.Login login) {
        this.login = login;
    }
    public void proceed(boolean isHome) throws IOException {
        if (isHome) {
            if (!doesMaxAttemptReached()) {
                if (attemptLogin())
                    goToHomeOrLogin(true);
            } else {
                Alerts.alertLoginAttempt(true, true);
            }
        } else {
            goToRegister();
        }
    }

    private void goToHomeOrLogin(boolean loggedIn) throws IOException {
        String resource = loggedIn ? Scenes.HOME.getPath() : Scenes.LOGIN.getPath(); ;
        String title = loggedIn ? Scenes.HOME.getTitle() : Scenes.LOGIN.getTitle();

        fxmlLoader = new FXMLLoader(Login.class.getResource(resource));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();
    }

    private void goToRegister() throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource(Scenes.REGISTER.getPath()));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(Scenes.REGISTER.getTitle());
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
        return (!login.txtFieldEmail.getText().isEmpty() && !login.txtFieldPassword.getText().isEmpty());
    }

    private boolean checkInList() {
        String email = login.txtFieldEmail.getText();
        String password = login.txtFieldPassword.getText();

        if (loginHashMap.containsKey(email)) {
            if (loginHashMap.containsValue(password)) {
                return true;
            } else {
                Alerts.alertLoginAttempt(true, false);
            }
        } else {
            Alerts.alertLoginAttempt(false, false);
        }
        return false;
    }
}
