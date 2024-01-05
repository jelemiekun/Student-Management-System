package com.example.fxstudentmanagement.Controllers.Controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Home implements Initializable {
    private com.example.fxstudentmanagement.Controllers.Logics.Home home;

    @FXML
    private Button btnAddSection;

    @FXML
    private Button btnDeleteSection;

    @FXML
    private Button btnEditProfile;

    @FXML
    private Button btnLogout;

    @FXML
    private Button btnViewSection;

    @FXML
    private TableColumn<?, ?> colNumber;

    @FXML
    private TableColumn<?, ?> colSection;

    @FXML
    private TableColumn<?, ?> colStudentCount;

    @FXML
    private Label labelDepartmentHere;

    @FXML
    private Label labelNameHere;

    @FXML
    private Label labelTotalCount;

    @FXML
    private TableView<?> tableView;

    @FXML
    private AnchorPane totalCounterAnchorPane;

    @FXML
    void btnAddSectionClicked(MouseEvent event) {

    }

    @FXML
    void btnDeleteSectionClicked(MouseEvent event) {

    }

    @FXML
    void btnEditProfileClicked(MouseEvent event) {

    }

    @FXML
    void btnLogoutClicked(MouseEvent event) {

    }

    @FXML
    void btnViewSectionClicked(MouseEvent event) {

    }

    @FXML
    void tableViewRowClicked(MouseEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        home = new com.example.fxstudentmanagement.Controllers.Logics.Home();
        home.setHome(this);
    }
}
