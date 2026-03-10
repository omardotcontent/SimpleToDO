package omar.projects.simpletodo.handlers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import omar.projects.simpletodo.controllers.CreateTaskController;
import omar.projects.simpletodo.data.TaskData;
import omar.projects.simpletodo.objects.Task;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class TaskHandler {

    private static VBox tasks;

    private static final List<Task> taskData = new ArrayList<>();


    public static List<Task> getTaskData() {
        return taskData;
    }

    public static void setTasks(final VBox current) {
        tasks = current;
    }

    public static void removeTask(Task task) {
        tasks.getChildren().remove(task);               // remove from your list
        getTasks().getChildren().remove(task.getTaskBox()); // remove from UI
    }


    public static void saveTasks() {
        final List<TaskData> data = taskData.stream()
                .map(Task::toData)
                .collect(Collectors.toList());
        DataHandler.save(data);
    }

    public static VBox getTasks() {
        return tasks;
    }


    public static void openPopupDialog(final Task task) {
        try {
            final FXMLLoader loader = new FXMLLoader(TaskHandler.class.getResource("/omar/projects/simpletodo/pages/createTask.fxml"));

            final Parent popupRoot = loader.load();

            final CreateTaskController popupController = loader.getController();

            popupController.init(task);

            final Stage popupStage = new Stage();
            popupStage.setTitle("Task Editor");

            popupStage.setScene(new Scene(popupRoot));
            popupStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
