module omar.projects.simpletodo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens omar.projects.simpletodo to javafx.fxml;
    opens omar.projects.simpletodo.controllers to javafx.fxml;
    exports omar.projects.simpletodo;
}