package duke;
import java.util.Scanner;
public class Parser {

    public static final String SPACE = " ";

    public String getCommandType(String command) {

        String commandType;
        String[] arr = command.split(SPACE);

        if (command.contains(SPACE)) {

            commandType = arr[0];
        } else {
            commandType = command;
        }
        return commandType;
    }

    public String getCommandTask(String command) {

        String commandTask;
        String[] arr = command.split(SPACE);
        if (arr.length > 1) {
            int indexOfTask = command.indexOf(SPACE);
            commandTask = command.substring(indexOfTask);
        } else {
            commandTask = null;
        }
        return commandTask;
    }

    public String getCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public int indexOfTask(String command) {
        int dividerPosition = command.indexOf(SPACE);
        String substring = command.substring(dividerPosition + 1);
        return (Integer.parseInt(substring) - 1);
    }

}
