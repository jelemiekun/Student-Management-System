package com.example.fxstudentmanagement.Controllers.Controllers;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;

import com.example.fxstudentmanagement.Controllers.Logics.RegisterOrEditModel;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegisterOrEditController implements Initializable {
    private RegisterOrEditModel registerOrEditModel;
    private RegisterOrEditModel.EditProfile editProfile;

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
        registerOrEditModel.btnGoBackClicked();
    }

    @FXML
    void btnRegisterOrDoneClicked(MouseEvent event) throws IOException{
        registerOrEditModel.btnRegisterClicked();
    }

    @FXML
    void genderClicked(MouseEvent event) {
        registerOrEditModel.getGender();
    }
    @FXML
    void genderPressedEnter(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER)
            registerOrEditModel.getGender();
    }
    @FXML
    void txtFieldReleased(KeyEvent event) {
        if (registerOrEditModel.editMode)
            editProfile.changesMade();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        registerOrEditModel = new RegisterOrEditModel();
        registerOrEditModel.setRegisterOrEdit(this);
        registerOrEditModel.setSpinner();
        if (teacherUsing != null)
            registerOrEditModel.setEditProfile();

        choiceBoxGradeLevel.setItems(gradeLevel);
        choiceBoxGradeLevel.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            registerOrEditModel.gradeLevelTeachingSelected();
        });
    }

    public void editTeacher() {
        editProfile = registerOrEditModel.new EditProfile();
        editProfile.setProfileFields();
    }

}