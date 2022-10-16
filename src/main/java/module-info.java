module mss.modern_school_system {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires commons.validator;


    opens mss.modern_school_system to javafx.fxml;
    exports mss.modern_school_system;
    exports mss.modern_school_system.controller;
    opens mss.modern_school_system.controller to javafx.fxml;
}