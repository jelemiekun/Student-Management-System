package com.example.fxstudentmanagement.Controllers.Controllers;

import com.example.fxstudentmanagement.Controllers.Logics.HomeModel;
import com.example.fxstudentmanagement.Resources.Objects.Section;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomeController implements Initializable {
    private HomeModel homeModel;

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
    public TableView<Section> tableView;
    @FXML
    public TableColumn<Section, Integer> colNumber;

    @FXML
    public TableColumn<Section, String> colSection;

    @FXML
    public TableColumn<Section, Integer> colStudentCount;

    @FXML
    public Label labelDepartmentHere;

    @FXML
    public Label labelNameHere;

    @FXML
    public Label labelTotalCount;

    @FXML
    public AnchorPane totalCounterAnchorPane;

    @FXML
    void btnAddSectionClicked(MouseEvent event) {

    }

    @FXML
    void btnDeleteSectionClicked(MouseEvent event) {

    }

    @FXML
    void btnEditProfileClicked(MouseEvent event) throws IOException {
        homeModel.editProfile();
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
        homeModel = new HomeModel();
        homeModel.setHome(this);
        homeModel.initialize();
    }
}