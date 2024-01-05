package com.example.fxstudentmanagement.Controllers.Controllers;

import com.example.fxstudentmanagement.Resources.Miscellaneous.Lists;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
    public Lists lists;
    @FXML
    public Button btnLogin;

    @FXML
    public Button btnRegister;

    @FXML
    public TextField txtFieldEmail;

    @FXML
    public PasswordField txtFieldPassword;
    @FXML
    public TextField txtFieldViewPass;
    @FXML
    public CheckBox checkViewPass;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        login = new com.example.fxstudentmanagement.Controllers.Logics.Login();
        login.setLogin(this);

        lists = new Lists();
    }
    @FXML
    void btnLoginClicked(MouseEvent event) throws IOException {
        login.proceed(true);
    }
    @FXML
    void btnRegisterClicked(MouseEvent event) throws IOException {
        login.proceed(false);
    }
    @FXML
    void txtFieldPressedEnter(KeyEvent event) throws IOException {
        if (event.getCode() == KeyCode.ENTER) {
            login.proceed(true);
        }
    }

    @FXML
    void checkViewPassSelected(ActionEvent event) {
        login.viewPass();
    }
}
