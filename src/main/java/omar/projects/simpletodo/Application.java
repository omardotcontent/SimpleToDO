package omar.projects.simpletodo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        final FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("pages/mainApplication.fxml"));
        stage.setTitle("Simple TO-DO - 1.0.0");
        stage.setScene(new Scene(fxmlLoader.load(), 320, 240));
        stage.show();
    }
}
