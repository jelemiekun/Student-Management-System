package com.example.fxstudentmanagement.Controllers.Controllers;

import com.example.fxstudentmanagement.Controllers.Logics.CredentialsModel;
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

public class CredentialsController implements Initializable {
    private CredentialsModel credentialsModel;
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
    void btnGoBackClicked(MouseEvent event) throws IOException{
        credentialsModel.goBack();
    }

    @FXML
    void btnConfirmClicked(MouseEvent event) throws IOException {
        credentialsModel.checkInputs();
    }

    @FXML
    void pressedEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER)
            credentialsModel.checkInputs();
    }

    @FXML
    void cancelPressedEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER)
            credentialsModel.goBack();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        credentialsModel = new CredentialsModel();
        credentialsModel.setCredentials(this);
    }
}
