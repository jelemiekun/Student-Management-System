package com.example.fxstudentmanagement.Controllers.Controllers;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterOrEdit implements Initializable {
    private com.example.fxstudentmanagement.Controllers.Logics.RegisterOrEdit registerOrEdit;

    @FXML
    public DatePicker birthday;

    @FXML
    public Button btnCancel;

    @FXML
    public Button btnRegister;

    @FXML
    public ChoiceBox<String> choiceBoxDepartment;

    @FXML
    public ChoiceBox<Integer> choiceBoxGradeLevel;

    @FXML
    public ToggleGroup gender;

    @FXML
    public RadioButton radioBtnFemale;

    @FXML
    public RadioButton radioBtnMale;

    @FXML
    public RadioButton radioBtnOther;

    @FXML
    public Spinner<Integer> spinnerAge;

    @FXML
    public TextField txtFieldEmployeeID;

    @FXML
    public TextField txtFieldFirstName;

    @FXML
    public TextField txtFieldLastName;

    @FXML
    public TextField txtFieldMiddleName;

    @FXML
    public TextField txtFieldPhoneNumber;
    public static FXMLLoader fxmlLoader;
    public static Parent root;
    public static Scene scene;
    public static Stage stage;

    @FXML
    void btnGoBackClicked(MouseEvent event) throws IOException {
        registerOrEdit.proceed(false);
    }

    @FXML
    void btnRegisterOrDoneClicked(MouseEvent event) throws IOException{
        registerOrEdit.btnRegisterClicked();
    }

    @FXML
    void genderClicked(MouseEvent event) {
        registerOrEdit.getGender();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerOrEdit = new com.example.fxstudentmanagement.Controllers.Logics.RegisterOrEdit();
        registerOrEdit.setRegisterOrEdit(this);
        registerOrEdit.setSpinner();

        choiceBoxGradeLevel.setItems(gradeLevel);
        choiceBoxGradeLevel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            registerOrEdit.gradeLevelTeachingSelected();
        });
    }

}

