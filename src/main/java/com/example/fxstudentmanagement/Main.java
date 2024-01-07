package com.example.fxstudentmanagement;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.credentialsTeacherHashMap;
import static com.example.fxstudentmanagement.Resources.SQL.SQL.createConnection;

import com.example.fxstudentmanagement.Resources.Miscellaneous.Scenes;
import com.example.fxstudentmanagement.Resources.Objects.Credentials;
import com.example.fxstudentmanagement.Resources.Objects.Teacher;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        createConnection();

        stage.setTitle("Student Management System");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle(Scenes.LOGIN.getTitle());
        stage.show();
    }



    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        Teacher teacher = new Teacher("John Jeremie", "Eden", "Male", 17, "09208905313", localDate, 29, 12, "ICT");
        Credentials credentials = new Credentials("admin", "admin");
        teacherSet.add(teacher);
        credentialsSet.add(credentials);

        loginMap.put("admin", "admin");

        credentialsTeacherHashMap.put(credentials, teacher);
        launch(args);
    }
}