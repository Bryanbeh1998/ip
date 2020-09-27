package duke.tasks;

public class Todo extends Task{
    public static final String todoIcon = "[T]";

    public Todo(String description) {
        super(description);
    }

    public String getTaskIcon() {
        return todoIcon;
    }

    @Override
    public String toString() {
        return todoIcon + super.toString();
    }
}
