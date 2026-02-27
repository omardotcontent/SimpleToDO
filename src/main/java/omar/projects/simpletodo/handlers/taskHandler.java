package omar.projects.simpletodo.handlers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import omar.projects.simpletodo.controllers.CreateTaskController;
import omar.projects.simpletodo.objects.Task;

import java.io.IOException;

public final class taskHandler {

    private static VBox tasks;


    public static void setTasks(final VBox current) {
        tasks = current;
    }

    // In tasksSaver
    public static void removeTask(Task task) {
        tasks.getChildren().remove(task);               // remove from your list
        getTasks().getChildren().remove(task.getTaskBox()); // remove from UI
    }

    public static VBox getTasks() {
        return tasks;
    }


    public static void openPopupDialog(final Task task) {
        try {
            final FXMLLoader loader = new FXMLLoader(taskHandler.class.getResource("/omar/projects/simpletodo/pages/createTask.fxml"));;

            final Parent popupRoot = loader.load();

            final CreateTaskController popupController = loader.getController();

            popupController.init(task);

            final Stage popupStage = new Stage();
            popupStage.setTitle("Popup Dialog");

            final Scene scene = new Scene(popupRoot);
            popupStage.setScene(scene);
            popupStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
