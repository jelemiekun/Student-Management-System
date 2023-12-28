package com.example.fxstudentmanagement;

import com.example.fxstudentmanagement.Resources.Objects.Student;
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
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Scene1.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Student Management System");
        stage.setResizable(false);
        stage.setScene(scene);
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