package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEditController;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Alerts.*;
import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import com.example.fxstudentmanagement.Resources.Objects.Section;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;

public class HomeModel {
    private RegisterOrEditController registerOrEditController;
    private com.example.fxstudentmanagement.Controllers.Controllers.HomeController homeController;
    private FXMLLoader fxmlLoader;
    private Parent root;
    private Scene scene;
    private Stage stage;

    public void setHome(com.example.fxstudentmanagement.Controllers.Controllers.HomeController homeController) {
        this.homeController = homeController;
    }

    public void initialize() {
        homeController.tableView.setItems(teacherUsing.sectionObservableList);
        homeController.colNumber.setCellValueFactory(new PropertyValueFactory<>("sectionNumber"));
        homeController.colSection.setCellValueFactory(new PropertyValueFactory<>("sectionName"));
        homeController.colStudentCount.setCellValueFactory(new PropertyValueFactory<>("sectionStudentCount"));

        setFields();
    }

    private void setFields() {
        homeController.labelTotalCount.setText("0");
        homeController.labelNameHere.setText(teacherUsing.getLastName() + ", " + teacherUsing.getFirstName() + " " + teacherUsing.getMiddleName());
        homeController.labelDepartmentHere.setText(teacherUsing.getGradeLevelTeaching().toString() + " - " + teacherUsing.getDepartment() + " department");
    }

    public void editProfile() throws IOException {
        goToAnotherScene(false, false);
    }

    public void logout() throws IOException {
        if (alertReturnBoolean(true, false, "")) {
            goToAnotherScene(true, false);
            teacherUsing = null;
            credentialsUsing = null;
        }
    }

    public void addSection() {
        Section section = new Section();
        teacherUsing.sectionObservableList.add(section);
    }

    public void btnDeleteSectionClicked() throws IOException {
        checkIfSelectedSectionIsNull(true);
    }

    public void clickedRow(MouseEvent event) throws IOException {
        selectedSection = homeController.tableView.getSelectionModel().getSelectedItem();
        if (event.getClickCount() == 2)
            checkIfSelectedSectionIsNull(false);
    }

    public void checkIfSelectedSectionIsNull(boolean toDelete) throws IOException {
        if (selectedSection != null) {
            if (toDelete)
                deleteSection();
            else
                goToAnotherScene(false, true);
        }
    }

    private void deleteSection() {
        if (alertReturnBoolean(false, true, selectedSection.getSectionName())) {
            teacherUsing.sectionObservableList.remove(selectedSection);
            clearClickedRow();
        }
    }

    public void clearClickedRow() {
        homeController.labelTotalCount.setText(getTotalCount());
        homeController.tableView.getSelectionModel().clearSelection();
        homeController.tableView.refresh();
        selectedSection = null;
    }

    private String getTotalCount() {
        int totalCount = 0;

        for (Section section : teacherUsing.sectionObservableList) {
            totalCount += section.getSectionStudentCount();
        }

        return String.valueOf(totalCount);
    }

    private void goToAnotherScene(boolean toLogin, boolean toSection) throws IOException {
        String path = toLogin ? Scenes.LOGIN.getPath() : (toSection ? Scenes.SECTION.getPath() : Scenes.EDIT.getPath());
        String title = toLogin ? Scenes.LOGIN.getTitle() : (toSection ? Scenes.SECTION.getTitle() : Scenes.EDIT.getTitle());

        fxmlLoader = new FXMLLoader(getClass().getResource(path));
        root = fxmlLoader.load();

        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);

        if (toSection) {
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(homeController.labelNameHere.getScene().getWindow());
        }

        stage.show();

        if (!toLogin && !toSection) {
            registerOrEditController = fxmlLoader.getController();
            registerOrEditController.editTeacher();
        }

        if (!toSection)
            closeThisStage();
    }

    private void closeThisStage() {
        Stage thisStage = (Stage) homeController.labelNameHere.getScene().getWindow();
        thisStage.close();
    }
}
