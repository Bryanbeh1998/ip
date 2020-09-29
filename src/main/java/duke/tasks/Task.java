package duke.tasks;
public class Task {
    protected String description;
    protected boolean isDone;

    public String getTaskIcon() {
        return null;
    }

    public void markAsDone() {
        isDone = true;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return (isDone ? "DONE" : "PENDING");
    }

    public String toString() {
        return "[" + getStatusIcon() + "]" + description;
    }



}

