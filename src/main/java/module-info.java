module omar.projects.simpletodo {
    requires javafx.controls;
    requires javafx.fxml;

    opens omar.projects.simpletodo to javafx.fxml;
    opens omar.projects.simpletodo.controllers to javafx.fxml;
    exports omar.projects.simpletodo;
}