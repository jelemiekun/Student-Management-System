package com.example.fxstudentmanagement.Resources.Miscellaneous;

import com.example.fxstudentmanagement.Resources.Objects.Credentials;
import com.example.fxstudentmanagement.Resources.Objects.Section;
import com.example.fxstudentmanagement.Resources.Objects.Teacher;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.*;

public class Lists {
    public static Teacher teacher;
    public static Set<Teacher> teacherHashSet = new HashSet<>();
    public static Map<Teacher, List<Section>> sectionTeacherHashMap = new HashMap<>();
    public static Map<Credentials, Teacher> credentialsTeacherHashMap = new HashMap<>();
    public static Map<String, String> loginMap = new HashMap<>();


    public static ObservableList<Integer> gradeLevel = FXCollections.observableArrayList(
            7, 8, 9, 10, 11, 12
    );
    public static ObservableList<String> JHSDepartments = FXCollections.observableArrayList(
            "FILIPINO", "ENGLISH", "ARALING PANLIPUNAN", "T.L.E.", "MATH", "SCIENCE", "EDUKASYON SA PAGPAPAKATAO", "M.A.P.E.H.", "E.P.P."
    );

    public static ObservableList<String> SHSDepartments = FXCollections.observableArrayList(
            "ABM", "A.D.", "HE 3", "HE 4", "HUMSS", "IA", "ICT Programming", "ICT CSS", "STEM", "SPORTS"
    );
    public static ObservableList<String> ABMobservableList = FXCollections.observableArrayList(
            "DINAR", "DOLAR", "EURO", "PESO", "POUND", "REAL", "RINGGIT", "WON", "YEN"
    );
    public static ObservableList<String> ADobservableList = FXCollections.observableArrayList(
            "ARTISTRY", "CREATIVITY", "HARMONY"
    );
    public static ObservableList<String> HE3observableList = FXCollections.observableArrayList(
            "BARISTA", "CHEF DE CUISINE", "COMMIS CHEF", "PASTRY CHEF", "SOMMELIER", "SOUES CHEF"
    );
    public static ObservableList<String> HE4observableList = FXCollections.observableArrayList(
            "ASTORIA", "LINDEN", "MARCO POLO"
    );
    public static ObservableList<String> HUMSSobservableList = FXCollections.observableArrayList(
            "ARISTOTLE", "BRONTE", "CONFUCIUS", "DESCARTES", "ELIOT", "FREUD", "GANDHI", "HUME"
    );
    public static ObservableList<String> IAobservableList = FXCollections.observableArrayList(
            "MITSUBISHI"
    );
    public static ObservableList<String> ICTCOMPPROGobservableList = FXCollections.observableArrayList(
            "DELPHI", "JAVASCRIPT", "KOTLIN", "MATLAB", "PYTHON", "RUBY", "SWIFT"
    );
    public static ObservableList<String> ICTCSSobservableList = FXCollections.observableArrayList(
            "AMD", "INTEL"
    );
    public static ObservableList<String> STEMobservableList = FXCollections.observableArrayList(
            "AMETHYST", "BARITE", "CITRINE", "DIAMOND", "EMERALD", "FELDSPAR", "GARNET", "HALITE", "IDOCRASE", "JADE"
    );
    public static ObservableList<String> SPORTSobservableList = FXCollections.observableArrayList(
            "ARCHERY", "BASKETBALL"
    );
}
