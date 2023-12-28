module com.example.fxstudentmanagement {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.fxstudentmanagement to javafx.fxml;
    exports com.example.fxstudentmanagement;
    exports com.example.fxstudentmanagement.Controllers;
    opens com.example.fxstudentmanagement.Controllers to javafx.fxml;
}