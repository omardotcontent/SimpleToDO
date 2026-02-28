package omar.projects.simpletodo.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import omar.projects.simpletodo.handlers.taskHandler;
import omar.projects.simpletodo.objects.Task;

public final class CreateTaskController {

    private Task currentTask;

    @FXML
    private Button applyButton;

    @FXML
    private Button createButton;

    @FXML
    private Button deleteButton;

    @FXML
    private TextField nameField;

    @FXML
    private TextField descriptionField;

    @FXML
    public void initialize() {
    }

    public void init(final Task task) {
        if (task != null) {
            currentTask = task;
            applyButton.setVisible(true);
            deleteButton.setVisible(true);
            createButton.setVisible(false);

            createButton.setManaged(false);

            nameField.setText(task.getName());
            descriptionField.setText(task.getDescription());

            applyButton.setOnAction(e -> {
                task.setName(nameField.getText());
                task.setDescription(descriptionField.getText());
            });
            deleteButton.setOnAction(e -> {
                taskHandler.removeTask(task);
                currentTask = null;
                ((Stage) nameField.getScene().getWindow()).close();
            });

        } else {

            applyButton.setVisible(false);
            createButton.setVisible(true);
            deleteButton.setVisible(false);

            applyButton.setManaged(false);
            deleteButton.setManaged(false);

            createButton.setOnAction(e -> {
                        new Task(nameField.getText(), descriptionField.getText(), false, taskHandler.getTasks());
                        ((Stage) nameField.getScene().getWindow()).close();
                    }
            );

        }

    }

}