package com.example.fxstudentmanagement.Resources.Objects;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Section {
    private ObservableList<Student> studentObservableList;

    public Section() {
        studentObservableList = FXCollections.observableArrayList();
    }
}
