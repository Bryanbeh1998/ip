package duke.tasks;
public class Event extends Task {

    protected String at;
    public static final String eventIcon = "[E]" ;
    public Event(String description, String at) {
        super(description);
        this.at = at;
    }
    public String getTaskIcon() {
        return eventIcon;
    }

    @Override
    public String toString() {
        return eventIcon + super.toString() + " (at: " + at + ")";
    }
}
