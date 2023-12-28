package com.example.fxstudentmanagement.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Scene1 {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}