package com.example.fxstudentmanagement.Resources.Miscellaneous;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class Alerts {
    public static String alertSetHeaderText;
    public static String alertSetContentText;
    private static Alert alert;

    public static void sqlAlert(boolean ifAlert) {
        if (ifAlert)
            alert = new Alert(Alert.AlertType.ERROR);
        else
            alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("SQL Alert");
        alert.setHeaderText(alertSetHeaderText);
        alert.setContentText(alertSetContentText);
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

    public static void alertPasswordMismatch(boolean isEmail) {
        alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(isEmail ? "Email already exists." : "Incorrect password");
        alert.setContentText(isEmail ? "Unable to create account. Email is already registered." : "Password and Confirm Password do not match.");
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

    public static boolean alertReturnBoolean(boolean isLogout, boolean isDeleteSection, String section) {
        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(isLogout ? "Log out" : (isDeleteSection ? "Delete Section" : "Unsaved Changes."));
        alert.setHeaderText(isLogout ? "Confirm log out." : (isDeleteSection ? "Delete " + section + "?" : "You have unsaved changes."));
        alert.setContentText(isLogout ? "Press \"OK\" if you want to log-out." : (isDeleteSection ? "This action cannot be undone." : "Press \"OK\" if you want to exit without saving changes."));
        ButtonType okButton = new ButtonType("OK");
        ButtonType cancelButton = new ButtonType("Cancel");
        alert.getButtonTypes().setAll(okButton, cancelButton);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == okButton;
    }

    public static void alertSection(boolean isSectionInfo, boolean isStudentID) {
        alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Can't perform action");
        alert.setHeaderText(isSectionInfo ? "Edit section info first" : (isStudentID ? "Invalid Student ID" : "Fill all text fields"));
        alert.setContentText(isSectionInfo ? "Please edit this section information first before adding a student.\n\n" +
                                             "Note: You can leave the adviser name and adviser department blank." :
                            (isStudentID ? "Please input a valid number for student ID. (1-99)" : "Please fill out all the necessary info."));
        alert.showAndWait();
    }

    public static void alertStudentID() {
        alert = new Alert((Alert.AlertType.ERROR));
        alert.setTitle("Can't perform action");
        alert.setHeaderText("Student ID already exists");
        alert.setContentText("Please input a unique student ID.");
        alert.show();
    }
}
