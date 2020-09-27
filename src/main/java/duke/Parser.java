package duke;
import java.util.Scanner;
public class Parser {

    public String getCommandType(String command) {

        String commandType;
        String[] arr = command.split(" ");

        if (command.contains(" ")) {

            commandType = arr[0];
        } else {
            commandType = command;
        }
        return commandType;
    }

    public String getCommandTask(String command) {

        String commandTask;
        String[] arr = command.split(" ");
        if (arr.length > 1) {
            int indexOfTask = command.indexOf(" ");
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
        int dividerPosition = command.indexOf(" ");
        String substring = command.substring(dividerPosition + 1);
        return (Integer.parseInt(substring) - 1);
    }

}
