package com.example.fxstudentmanagement.SQL;

import javafx.scene.control.Alert;

public class SQLAlert {
    public static String AlertsetHeaderText;
    public static String AlertsetContentText;
    private static Alert alert;

    public static void sqlAlert(boolean ifAlert) {
        if (ifAlert)
            alert = new Alert(Alert.AlertType.ERROR);
        else
            alert = new Alert(Alert.AlertType.INFORMATION);

        alert.setTitle("SQLAlert");
        alert.setHeaderText(AlertsetHeaderText);
        alert.setContentText(AlertsetContentText);
        alert.show();
    }


}
