package com.example.fxstudentmanagement.Controllers.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {
    private com.example.fxstudentmanagement.Controllers.Logics.Login login;
    public static FXMLLoader fxmlLoader;
    public static Parent root;
    public static Scene scene;
    public static Stage stage;
    public static Stage thisStage;
    @FXML
    public Button btnLogin;

    @FXML
    public Button btnRegister;

    @FXML
    public TextField txtFieldEmail;

    @FXML
    public PasswordField txtFieldPassword;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login = new com.example.fxstudentmanagement.Controllers.Logics.Login();
    }
    @FXML
    void btnLoginClicked(MouseEvent event) throws IOException {
        setThisStage();
        thisStage.close();
        login.proceed(true);
    }
    @FXML
    void btnRegisterClicked(MouseEvent event) throws IOException {
        setThisStage();
        thisStage.close();
        login.proceed(false);
    }
    @FXML
    void txtFieldPressedEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {

        }
    }
    private void setThisStage() {
        thisStage = (Stage) btnLogin.getScene().getWindow();
    }

}
