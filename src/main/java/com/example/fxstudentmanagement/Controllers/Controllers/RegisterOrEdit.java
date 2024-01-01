package com.example.fxstudentmanagement.Controllers.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class RegisterOrEdit {

    @FXML
    private DatePicker birthday;

    @FXML
    private Button btnCancel;

    @FXML
    private Button btnRegister;

    @FXML
    private ChoiceBox<?> choiceBoxDepartment;

    @FXML
    private ChoiceBox<?> choiceBoxGradeLevel;

    @FXML
    private ToggleGroup gender;

    @FXML
    private RadioButton radioBtnFemale;

    @FXML
    private RadioButton radioBtnMale;

    @FXML
    private RadioButton radioBtnOther;

    @FXML
    private Spinner<?> spinnerAge;

    @FXML
    private TextField txtFieldEmployeeID;

    @FXML
    private TextField txtFieldFirstName;

    @FXML
    private TextField txtFieldLastName;

    @FXML
    private TextField txtFieldMiddleName;

    @FXML
    private TextField txtFieldPhoneNumber;

    @FXML
    void btnCancelClicked(MouseEvent event) {

    }

    @FXML
    void btnRegisterClicked(MouseEvent event) {

    }

}

