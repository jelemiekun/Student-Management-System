package com.example.fxstudentmanagement.Controllers.Logics;

import com.example.fxstudentmanagement.Controllers.Controllers.SectionController;
import static com.example.fxstudentmanagement.Resources.Miscellaneous.Lists.selectedSection;

public class SectionModel {
    private SectionController sectionController;

    public void setSectionController(SectionController sectionController) {
        this.sectionController = sectionController;
    }

    public void initialize() {
        sectionController.labelSection.setText(selectedSection.getSectionName());
    }
}
