package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import static com.example.fxstudentmanagement.Controllers.Controllers.Login.*;
import java.io.IOException;

public class Login {
    public void proceed(boolean isHome) throws IOException {
        if (isHome)
            attemptLogin();

        String resource = isHome ? Scenes.HOME.getPath() : Scenes.REGISTER.getPath(); ;
        String title = isHome ? Scenes.HOME.getTitle() : Scenes.REGISTER.getTitle();

        fxmlLoader = new FXMLLoader(Login.class.getResource(resource));
        root = fxmlLoader.load();
        scene = new Scene(root);
        stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle(title);
        stage.show();
    }

    private void attemptLogin() {
    }
}
