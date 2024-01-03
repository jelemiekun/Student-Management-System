package com.example.fxstudentmanagement.Controllers.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Credentials implements Initializable {
    private com.example.fxstudentmanagement.Controllers.Logics.Credentials credentials;
    @FXML
    private Button btnCancel;

    @FXML
    private Button btnConfirm;
    @FXML
    public TextField txtFieldEmail;
    @FXML
    public PasswordField txtFieldPassword;
    @FXML
    public PasswordField txtFieldConfirmPassword;

    @FXML
    void btnGoBackClicked(MouseEvent event) {
        credentials.goBack();
    }

    @FXML
    void btnConfirmClicked(MouseEvent event) throws IOException {
        credentials.checkInputs();
    }

    @FXML
    void pressedEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER)
            credentials.checkInputs();
    }

    @FXML
    void cancelPressedEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            credentials.goBack();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        credentials = new com.example.fxstudentmanagement.Controllers.Logics.Credentials();
        credentials.setCredentials(this);
    }
}
