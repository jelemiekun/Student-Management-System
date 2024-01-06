package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Controllers.Controllers.RegisterOrEditController;
import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
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
        homeController.colNumber.setCellValueFactory(new PropertyValueFactory<>("numberOfSections"));
        homeController.colSection.setCellValueFactory(new PropertyValueFactory<>("section"));
        homeController.colStudentCount.setCellValueFactory(new PropertyValueFactory<>("sectionCount"));

        homeController.labelNameHere.setText(teacherUsing.getLastName() + ", " + teacherUsing.getFirstName() + " " + teacherUsing.getMiddleName());
        homeController.labelDepartmentHere.setText(teacherUsing.getDepartment());
    }

    public void editProfile() throws IOException {
        goToAnotherScene();
    }

    private void goToAnotherScene() throws IOException {
        fxmlLoader = new FXMLLoader(getClass().getResource(Scenes.EDIT.getPath()));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(Scenes.EDIT.getTitle());
        stage.show();

        registerOrEditController = fxmlLoader.getController();
        registerOrEditController.editTeacher();

        closeThisStage();
    }

    private void closeThisStage() {
        Stage thisStage = (Stage) homeController.labelNameHere.getScene().getWindow();
        thisStage.close();
    }
}
