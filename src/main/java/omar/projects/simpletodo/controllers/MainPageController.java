package omar.projects.simpletodo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import omar.projects.simpletodo.data.TaskData;
import omar.projects.simpletodo.handlers.DataHandler;
import omar.projects.simpletodo.handlers.TaskHandler;
import omar.projects.simpletodo.objects.Task;

import java.util.List;

public final class MainPageController {

    @FXML
    private VBox tasks;


    @FXML
    private Button createTaskButton;

    @FXML
    public void initialize() {
        TaskHandler.setTasks(tasks);
        createTaskButton.setOnAction(e -> {
           TaskHandler.openPopupDialog(null);
        });

        final List<TaskData> data = DataHandler.load();

        for (final TaskData t : data) {
            new Task(t.name, t.description, t.checked, tasks);
        }
    }

}
