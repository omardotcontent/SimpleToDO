package omar.projects.simpletodo.objects;

import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import omar.projects.simpletodo.data.TaskData;
import omar.projects.simpletodo.handlers.TaskHandler;



public final class Task {

    private String name;
    private String description;
    private boolean checked;

    private BorderPane taskBox;
    private Text nameText;
    private Text descriptionText;
    private CheckBox checkBox;


    public Task(final String name, final String description, final boolean checked, final VBox tasks) {
        this.name = name;
        this.description = description;
        this.checked = checked;
        setupBorderPane(tasks);
        setupEvents();
        TaskHandler.getTaskData().add(this);
    }

    private void setupBorderPane(final VBox tasks) {
        taskBox = new BorderPane();

        taskBox.getStyleClass().add("todo-item");

        nameText = new Text();
        nameText.setText(name);
        nameText.setTextAlignment(TextAlignment.LEFT);
        nameText.getStyleClass().add("title");

        descriptionText = new Text();
        descriptionText.setText(description);
        descriptionText.setTextAlignment(TextAlignment.LEFT);
        descriptionText.getStyleClass().add("description");

        checkBox = new CheckBox();
        checkBox.setSelected(checked);

        checkBox.setMinHeight(Region.USE_COMPUTED_SIZE);
        checkBox.setMinWidth(Region.USE_COMPUTED_SIZE);

        checkBox.setMaxHeight(Double.MAX_VALUE);
        checkBox.setMaxWidth(Double.MAX_VALUE);

        checkBox.setPrefHeight(Region.USE_COMPUTED_SIZE);
        checkBox.setPrefWidth(Region.USE_COMPUTED_SIZE);

        taskBox.setRight(checkBox);


        final VBox info = new VBox();
        info.getChildren().add(nameText);
        info.getChildren().add(descriptionText);

        info.setMinHeight(Region.USE_COMPUTED_SIZE);
        info.setMinWidth(Region.USE_COMPUTED_SIZE);

        info.setMaxHeight(Double.MAX_VALUE);
        info.setMaxWidth(Double.MAX_VALUE);

        info.setPrefHeight(Region.USE_COMPUTED_SIZE);
        info.setPrefWidth(Region.USE_COMPUTED_SIZE);

        info.setAlignment(Pos.CENTER_LEFT);


        taskBox.setLeft(info);

        taskBox.setMinHeight(Region.USE_COMPUTED_SIZE);
        taskBox.setMinWidth(Region.USE_COMPUTED_SIZE);
        taskBox.setMaxHeight(Double.MAX_VALUE);
        taskBox.setMaxWidth(Double.MAX_VALUE);

        taskBox.setPrefHeight(Region.USE_COMPUTED_SIZE);
        taskBox.setPrefWidth(Region.USE_COMPUTED_SIZE);

        tasks.getChildren().add(taskBox);


    }

    private void setupEvents() {
        checkBox.setOnAction(e -> {
            checked = checkBox.isSelected();
            System.out.println("Task '" + name + "' checked: " + checked);
        });

        taskBox.setOnMouseClicked(e -> {
            if (e.getClickCount() == 2) {
                TaskHandler.openPopupDialog(this);
            }
        });
    }

    public String getName() {
        return name;
    }


    public String getDescription() {
        return description;
    }

    public BorderPane getTaskBox() {
        return taskBox;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setName(final String name) {
        this.name = name;
        nameText.setText(name);
    }

    public void setDescription(final String description) {
        this.description = description;
        descriptionText.setText(description);
    }

    public void setChecked(final boolean checked) {
        this.checked = checked;
        checkBox.setSelected(checked);
    }

    public TaskData toData() {
        return new TaskData(name, description, checked);
    }

}