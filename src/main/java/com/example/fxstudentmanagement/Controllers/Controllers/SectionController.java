package com.example.fxstudentmanagement.Controllers.Controllers;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.gradeLevel;
import com.example.fxstudentmanagement.Controllers.Logics.SectionModel;
import com.example.fxstudentmanagement.Resources.Objects.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.time.LocalDate;
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
    public TableColumn<Student, Integer> colAge;

    @FXML
    public TableColumn<Student, LocalDate> colBirthdate;

    @FXML
    public TableColumn<Student, String> colFirstName;

    @FXML
    public TableColumn<Student, String> colGender;

    @FXML
    public TableColumn<Student, String> colLastName;

    @FXML
    public TableColumn<Student, String> colMiddleName;

    @FXML
    public TableColumn<Student, String> colPhoneNumber;

    @FXML
    public TableColumn<Student, Integer> colStudentID;

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
    public Label labelLevelStrand;

    @FXML
    public RadioButton radioBtnFemale;

    @FXML
    public RadioButton radioBtnMale;

    @FXML
    public Spinner<Integer> spinnerAge;

    @FXML
    public TableView<Student> tableView;

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
    public ComboBox<String> comboBoxSection;
    @FXML
    public ComboBox<Integer> comboBoxGradeLevel;
    @FXML
    public ComboBox<String> comboBoxStrand;
    @FXML
    public ComboBox<String> comboBoxDepartment;
    @FXML
    public TextField txtFieldTeacher;

    public String selectedGender;

    public Integer selectedAge;
    public LocalDate selectedBirthdate;

    @FXML
    void btnAddNewStudentClicked(MouseEvent event) {
        sectionModel.addStudent();
    }

    @FXML
    void btnDeleteSectionClicked(MouseEvent event) {
        sectionModel.deleteSection();
    }

    @FXML
    void btnDeleteStudentClicked(MouseEvent event) {

    }

    @FXML
    void btnEditSectionClicked(MouseEvent event) {
        sectionModel.editSectionInfo();
    }

    @FXML
    void btnGoBackClicked(MouseEvent event) {
        sectionModel.closeThisStage();
    }

    @FXML
    void tableViewRowClicked(MouseEvent event) {

    }

    @FXML
    void genderSelect(ActionEvent event) {
        sectionModel.setGender();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        sectionModel = new SectionModel();
        sectionModel.setSectionController(this);
        sectionModel.initialize();
        comboBoxGradeLevel.setItems(gradeLevel);
    }
}
