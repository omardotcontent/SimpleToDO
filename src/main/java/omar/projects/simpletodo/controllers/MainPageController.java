package omar.projects.simpletodo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import omar.projects.simpletodo.handlers.taskHandler;

public final class MainPageController {

    @FXML
    private VBox tasks;


    @FXML
    private Button createTaskButton;

    @FXML
    public void initialize() {
        taskHandler.setTasks(tasks);
        createTaskButton.setOnAction(e -> {
           taskHandler.openPopupDialog(null);
        });
    }

}
