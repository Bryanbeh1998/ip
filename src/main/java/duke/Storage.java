package duke;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Storage {

    private final String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(TaskList tasks) {
        try {
            FileWriter fw = new FileWriter(filePath);
            for (int i = 0; i < tasks.getTaskList().size(); i++) {
                fw.write(tasks.getTaskList().get(i).toString());
            }
            fw.close();
        } catch (IOException e) {
            System.out.println("Something went wrong while saving");
        }
    }
}
