package com.example.fxstudentmanagement.Resources.Lists;

import com.example.fxstudentmanagement.Resources.Objects.Credentials;
import com.example.fxstudentmanagement.Resources.Objects.Section;
import com.example.fxstudentmanagement.Resources.Objects.Student;
import com.example.fxstudentmanagement.Resources.Objects.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Lists {
    public static Set<Teacher> teacherHashSet = new HashSet<>();
    public static Map<Teacher, List<Section>> sectionTeacherHashMap = new HashMap<>();
    public static Map<Credentials, Teacher> loginHashMap = new HashMap<>();

    public static ObservableList<Integer> gradeLevel = FXCollections.observableArrayList(
            7, 8, 9, 10, 11, 12
    );
    public static ObservableList<String> JHSDepartments = FXCollections.observableArrayList(
            ""
    );
}
