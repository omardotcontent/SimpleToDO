module omar.projects.simpletodo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires com.fasterxml.jackson.databind;

    opens omar.projects.simpletodo to javafx.fxml;
    opens omar.projects.simpletodo.controllers to javafx.fxml;
    opens omar.projects.simpletodo.data to com.fasterxml.jackson.databind;
    exports omar.projects.simpletodo;
}