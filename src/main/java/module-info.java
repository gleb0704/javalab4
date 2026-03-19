module com.example.lab4 {
    requires javafx.controls;
    requires javafx.fxml;

    opens gui to javafx.graphics;

    exports gui;
    exports core;
    exports models;
    exports console;
}