package com.example.fxstudentmanagement.Resources.Miscellaneous;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

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

    public static void alertFormNotComplete(boolean ifForm, boolean ifEmployeeID) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(ifForm ? "Form is not complete." : (!ifEmployeeID ? "Invalid employee ID." : "Invalid phone number."));
        alert.setContentText(ifForm ? "Please fill out all details." : (!ifEmployeeID ? "Please input a valid employee ID." : "Please input a valid phone number. (09xxxxxxxxx)"));
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


    public static void alertLoginAttempt(boolean isWrongPassword, boolean doesMaxAttemptReached) {
        alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Login failed");
        alert.setHeaderText(doesMaxAttemptReached ? "Attempt limit reached." : "Login attempt failed.");
        alert.setContentText(doesMaxAttemptReached ? "You have reached the maximum attempt limit. Please try again later" :
                            (isWrongPassword ? "Wrong Password" : "Cannot find account."));
        alert.show();
    }

    public static boolean alertUnsavedChanges() {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Unsaved Changes.");
        alert.setHeaderText("You have unsaved changes.");
        alert.setContentText("Press \"OK\" if you want to exit without saving changes.");
        ButtonType okButton = new ButtonType("OK");
        ButtonType cancelButton = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(okButton, cancelButton);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == okButton;
    }
}
