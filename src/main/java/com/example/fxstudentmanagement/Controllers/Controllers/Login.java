package com.example.fxstudentmanagement.Controllers.Controllers;

import com.example.fxstudentmanagement.SQL.SQL;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static com.example.fxstudentmanagement.SQL.SQL.*;
import static com.example.fxstudentmanagement.Controllers.Logics.Login.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login  implements Initializable{
    public static FXMLLoader fxmlLoader;
    public static Parent root;
    public static Scene scene;
    public static Stage stage;
    public static Stage thisStage;
    private com.example.fxstudentmanagement.Controllers.Logics.Login login;
    @FXML
    public Button btnLogin;

    @FXML
    public Button btnRegister;

    @FXML
    public TextField txtFieldEmail;

    @FXML
    public TextField txtFieldPassword;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        CreateConnection();
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

    }

    private void setThisStage() {
        thisStage = (Stage) btnLogin.getScene().getWindow();
    }
}
