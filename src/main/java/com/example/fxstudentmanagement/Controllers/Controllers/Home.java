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
    public Button btnAddSection;

    @FXML
    public Button btnDeleteSection;

    @FXML
    public Button btnEditProfile;

    @FXML
    public Button btnLogout;

    @FXML
    public Button btnViewSection;

    @FXML
    public TableColumn<?, ?> colNumber;

    @FXML
    public TableColumn<?, ?> colSection;

    @FXML
    public TableColumn<?, ?> colStudentCount;

    @FXML
    public Label labelDepartmentHere;

    @FXML
    public Label labelNameHere;

    @FXML
    public Label labelTotalCount;

    @FXML
    public TableView<?> tableView;

    @FXML
    public AnchorPane totalCounterAnchorPane;

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
        home.initialize();
    }
}
