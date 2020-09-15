public class InvalidCommandException extends Exception{
    public static String description;

    public InvalidCommandException (String description) {
        this.description = description;
    }
}
