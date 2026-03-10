package omar.projects.simpletodo.handlers;

import com.fasterxml.jackson.databind.ObjectMapper;
import omar.projects.simpletodo.data.TaskData;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public final class DataHandler {

    private static final String FILE_PATH = getAppDataPath();
    private static final String APP_NAME = "SimpleTodoApp";
    private static final File FILE = new File(FILE_PATH);
    private static final ObjectMapper mapper = new ObjectMapper();

    public static void save(final List<TaskData> tasks) {
        try {
            mapper.writerWithDefaultPrettyPrinter().writeValue(FILE, tasks);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String getAppDataPath() {

        final String os = System.getProperty("os.name").toLowerCase();
        final String basePath;

        if (os.contains("win")) {
            basePath = System.getenv("APPDATA");
        } else if (os.contains("mac")) {
            basePath = System.getProperty("user.home") + "/Library/Application Support";
        } else {
            basePath = System.getProperty("user.home") + "/.config";
        }

        final String appDirPath = basePath + File.separator + APP_NAME;
        final File appDir = new File(appDirPath);

        if (!appDir.exists() && !appDir.mkdirs()) {
            throw new RuntimeException("Failed to create app directory: " + appDirPath);
        }


        return appDirPath + File.separator + "data.json";
    }

    public static List<TaskData> load() {
        try {
            if (!FILE.exists()) return new ArrayList<>();

            return mapper.readValue(
                    FILE,
                    mapper.getTypeFactory().constructCollectionType(List.class, TaskData.class)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}