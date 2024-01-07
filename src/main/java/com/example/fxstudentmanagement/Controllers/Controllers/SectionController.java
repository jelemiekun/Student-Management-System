package com.example.fxstudentmanagement.Controllers.Controllers;

import com.example.fxstudentmanagement.Controllers.Logics.SectionModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

import java.net.URL;
import java.util.ResourceBundle;

public class SectionController implements Initializable {
    private SectionModel sectionModel;

    @FXML
    public DatePicker birthDatePicker;

    @FXML
    public Button btnAddNewStudent;

    @FXML
    public Button btnDeleteSection;

    @FXML
    public Button btnDeleteStudent;

    @FXML
    public Button btnEditSection;

    @FXML
    public Button btnGoBack;

    @FXML
    public TableColumn<?, ?> colAge;

    @FXML
    public TableColumn<?, ?> colBirthdate;

    @FXML
    public TableColumn<?, ?> colFirstName;

    @FXML
    public TableColumn<?, ?> colGender;

    @FXML
    public TableColumn<?, ?> colLastName;

    @FXML
    public TableColumn<?, ?> colMiddleName;

    @FXML
    public TableColumn<?, ?> colPhoneNumber;

    @FXML
    public TableColumn<?, ?> colStudentID;

    @FXML
    public ToggleGroup gender;

    @FXML
    public Label labelAdviser;

    @FXML
    public Label labelDepartment;

    @FXML
    public Label labelGradeLevel;

    @FXML
    public Label labelSection;

    @FXML
    public Label labelStrand;

    @FXML
    public RadioButton radioBtnFemale;

    @FXML
    public RadioButton radioBtnMale;

    @FXML
    public Spinner<?> spinnerAge;

    @FXML
    public TableView<?> tableView;

    @FXML
    public TextField txtFieldFirstName;

    @FXML
    public TextField txtFieldLastName;

    @FXML
    public TextField txtFieldMiddleName;

    @FXML
    public TextField txtFieldPhoneNumber;

    @FXML
    public TextField txtFieldStudentID;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sectionModel = new SectionModel();
        sectionModel.setSectionController(this);
        sectionModel.initialize();
    }
}
