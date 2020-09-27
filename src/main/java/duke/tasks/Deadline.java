package duke.tasks;
public class Deadline extends Task {
    protected String by;
    public static final String deadlineIcon = "[D]";

    public Deadline(String description, String by){
        super(description);
        this.by = by;
    }

    public String getTaskIcon() {
        return deadlineIcon;
    }

    @Override
    public String toString() {
        return deadlineIcon + super.toString() + " (by: " + by + ")" ;
    }
}
