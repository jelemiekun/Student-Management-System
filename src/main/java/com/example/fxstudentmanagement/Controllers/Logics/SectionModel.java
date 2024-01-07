package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Controllers.Controllers.SectionController;
import com.example.fxstudentmanagement.Resources.Objects.Section;

public class SectionModel {
    private SectionController sectionController;
    private Section selectedSection;

    public void setSectionController(SectionController sectionController) {
        this.sectionController = sectionController;
    }

    public void initialize() {
        // SET SELECTED SECTION HERE
    }
}
