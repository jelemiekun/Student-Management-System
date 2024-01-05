package com.example.fxstudentmanagement.Controllers.Logics;

import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.*;

public class Home {
    private com.example.fxstudentmanagement.Controllers.Controllers.Home home;

    public void setHome(com.example.fxstudentmanagement.Controllers.Controllers.Home home) {
        this.home = home;
    }

    public void initialize() {
        home.labelNameHere.setText(teacherUsing.getLastName() + ", " + teacherUsing.getFirstName() + " " + teacherUsing.getMiddleName());
        home.labelDepartmentHere.setText(teacherUsing.getDepartment());
    }
}
