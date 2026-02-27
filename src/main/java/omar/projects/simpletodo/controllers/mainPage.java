package omar.projects.simpletodo.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import omar.projects.simpletodo.objects.Task;

public class mainPage {

    @FXML
    private VBox tasks;

    @FXML
    public void initialize() {
        new Task("Task 1", "This is the first task", false, tasks);
        new Task("Task 2", "This is the second task", true, tasks);
    }

}
