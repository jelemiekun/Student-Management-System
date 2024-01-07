module com.example.fxstudentmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens com.example.fxstudentmanagement.Resources.Objects to javafx.base;
    exports com.example.fxstudentmanagement;
    exports com.example.fxstudentmanagement.Controllers.Logics;
    opens com.example.fxstudentmanagement.Controllers.Logics to javafx.fxml;
    exports com.example.fxstudentmanagement.Controllers.Controllers;
    opens com.example.fxstudentmanagement.Controllers.Controllers to javafx.fxml;
}