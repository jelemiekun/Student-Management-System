package com.example.fxstudentmanagement.Resources.Miscellaneous;

import javafx.scene.control.Alert;

public class Alerts {
    public static String AlertsetHeaderText;
    public static String AlertsetContentText;
    private static Alert alert;

    public static void sqlAlert(boolean ifAlert) {
        if (ifAlert)
            alert = new Alert(Alert.AlertType.ERROR);
        else
            alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("SQL Alert");
        alert.setHeaderText(AlertsetHeaderText);
        alert.setContentText(AlertsetContentText);
        alert.show();
    }

    public static void alertFormNotComplete(boolean ifForm) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");

        if (ifForm) {
            alert.setHeaderText("Form is not complete.");
            alert.setContentText("Please fill out all details.");
        } else {
            alert.setHeaderText("Invalid employee ID.");
            alert.setContentText("Please input a valid integer employee ID.");
        }

        alert.show();
    }

    public static void alertRegisterDone() {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Success");
        alert.setHeaderText("Registered successfully!");
        alert.setContentText("Redirecting you to log-in page.");
        alert.showAndWait();
    }

    public static void alertPasswordMismatch() {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Incorrect password");
        alert.setContentText("Password and Confirm Password do not match.");
        alert.show();
    }
}
