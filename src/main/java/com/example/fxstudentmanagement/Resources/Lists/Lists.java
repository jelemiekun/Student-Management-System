package com.example.fxstudentmanagement.Resources.Lists;

import com.example.fxstudentmanagement.Resources.Objects.Credentials;
import com.example.fxstudentmanagement.Resources.Objects.Section;
import com.example.fxstudentmanagement.Resources.Objects.Student;
import com.example.fxstudentmanagement.Resources.Objects.Teacher;
import javafx.collections.ObservableList;

import java.util.*;

public class Lists {
    public static Set<Teacher> teacherHashSet = new HashSet<>();
    public static Map<Teacher, List<Section>> sectionTeacherHashMap = new HashMap<>();
    public static Map<Credentials, Teacher> loginHashMap = new HashMap<>();
}
