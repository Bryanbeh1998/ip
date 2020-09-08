public class Task {
    protected String description;
    protected boolean isDone;

    public void markAsDone() {
        isDone = true;
    }

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public String toString(){
        return "[" + getStatusIcon() + "]" + description;
    }



}
