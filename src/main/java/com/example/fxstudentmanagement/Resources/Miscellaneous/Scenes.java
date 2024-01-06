package com.example.fxstudentmanagement.Resources.Miscellaneous;

public enum Scenes {
    HOME("HomeModel", "/com/example/fxstudentmanagement/Home.fxml"),
    LOGIN("LoginModel", "/com/example/fxstudentmanagement/Login.fxml"),
    REGISTER("Register", "/com/example/fxstudentmanagement/RegisterOrEdit.fxml"),
    EDIT("Edit Profile", "/com/example/fxstudentmanagement/RegisterOrEdit.fxml"),
    CREDENTIALS("Account Information", "/com/example/fxstudentmanagement/Credentials.fxml"),
    SECTION("Sections", "/com/example/fxstudentmanagement/Section.fxml");

    private String title;
    private String path;

    Scenes(String title, String path) {
        this.title = title;
        this.path = path;
    }

    public String getTitle() {
        return title;
    }

    public String getPath() {
        return path;
    }
}
