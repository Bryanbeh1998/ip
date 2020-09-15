public class InvalidCommandException extends Exception{
    public String description;

    public InvalidCommandException(String description) {
        this.description = description;
    }
}
