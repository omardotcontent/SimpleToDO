package omar.projects.simpletodo.data;

public final class TaskData {

    public String name;
    public String description;
    public boolean checked;

    @SuppressWarnings("unused")
    public TaskData() {} // required for JSON

    public TaskData(final String name, final String description, final boolean checked) {
        this.name = name;
        this.description = description;
        this.checked = checked;
    }
}