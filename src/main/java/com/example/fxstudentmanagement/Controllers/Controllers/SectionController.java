package com.example.fxstudentmanagement.Controllers.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class SectionController {

    @FXML
    private DatePicker birthDatePicker;

    @FXML
    private Button btnAddNewStudent;

    @FXML
    private Button btnDeleteSection;

    @FXML
    private Button btnDeleteStudent;

    @FXML
    private Button btnEditSection;

    @FXML
    private Button btnGoBack;

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colBirthdate;

    @FXML
    private TableColumn<?, ?> colFirstName;

    @FXML
    private TableColumn<?, ?> colGender;

    @FXML
    private TableColumn<?, ?> colLastName;

    @FXML
    private TableColumn<?, ?> colMiddleName;

    @FXML
    private TableColumn<?, ?> colPhoneNumber;

    @FXML
    private TableColumn<?, ?> colStudentID;

    @FXML
    private ToggleGroup gender;

    @FXML
    private Label labelAdviser;

    @FXML
    private Label labelDepartment;

    @FXML
    private Label labelGradeLevel;

    @FXML
    private Label labelSection;

    @FXML
    private Label labelStrand;

    @FXML
    private RadioButton radioBtnFemale;

    @FXML
    private RadioButton radioBtnMale;

    @FXML
    private Spinner<?> spinnerAge;

    @FXML
    private TableView<?> tableView;

    @FXML
    private TextField txtFieldFirstName;

    @FXML
    private TextField txtFieldLastName;

    @FXML
    private TextField txtFieldMiddleName;

    @FXML
    private TextField txtFieldPhoneNumber;

    @FXML
    private TextField txtFieldStudentID;

    @FXML
    void btnAddNewStudentClicked(MouseEvent event) {

    }

    @FXML
    void btnDeleteSectionClicked(MouseEvent event) {

    }

    @FXML
    void btnDeleteStudentClicked(MouseEvent event) {

    }

    @FXML
    void btnEditSectionClicked(MouseEvent event) {

    }

    @FXML
    void btnGoBackClicked(MouseEvent event) {

    }

    @FXML
    void tableViewRowClicked(MouseEvent event) {

    }

}
