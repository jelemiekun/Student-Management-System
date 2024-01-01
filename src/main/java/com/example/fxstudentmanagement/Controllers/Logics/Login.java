package com.example.fxstudentmanagement.Controllers.Logics;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.example.fxstudentmanagement.Controllers.Controllers.Login.*;
import java.io.IOException;

public class Login {
    public void proceed(boolean isHome) throws IOException {
        String resource = isHome ? "/com/example/fxstudentmanagement/Home.fxml" : "/com/example/fxstudentmanagement/RegisterOrEdit.fxml" ;

        fxmlLoader = new FXMLLoader(Login.class.getResource(resource));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
