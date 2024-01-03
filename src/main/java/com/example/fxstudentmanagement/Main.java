package com.example.fxstudentmanagement;

import static com.example.fxstudentmanagement.Resources.SQL.SQL.createConnection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        createConnection();

        stage.setTitle("Student Management System");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.setTitle("Log-in");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        /*LocalDate localDate = LocalDate.now();
        Teacher teacher1 = new Teacher("first", "last", "god", 69, "911", localDate, 1, 12, "math");
        Student student1 = new Student("FIRST", "LAST", "GOD", 96, "143", localDate, 1, 12, "ebec", "garnet");
        Student student2 = new Student("FIRST", "LAST", "GOD", 96, "143", localDate, 1, 12, "ebec", "garnet");
        Student student3 = new Student("FIRST", "LAST", "GOD", 96, "143", localDate, 1, 12, "ebec", "garnet");
        Student student4 = new Student("FIRST", "LAST", "GOD", 96, "143", localDate, 1, 12, "ebec", "garnet");
        Student student5 = new Student("FIRST", "LAST", "GOD", 96, "143", localDate, 1, 12, "ebec", "garnet");

        teacher1.addSection();

        System.out.println((teacher1.sectionObservableList.isEmpty()));
        teacher1.sectionObservableList.get(0).addStudent(student1);

        System.out.println(teacher1.sectionObservableList.get(0).studentObservableList.get(0).getFirstName());

        System.out.println(teacher1.sectionObservableList.get(0));*/
    }
}