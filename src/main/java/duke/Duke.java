package duke;

import duke.tasks.Task;
import duke.exceptions.NullCommandException;
import duke.exceptions.InvalidCommandException;

public class Duke {
    //constants
    public static final String BYE_COMMAND = "bye";
    public static final String LIST_COMMAND = "list";
    public static final String DONE_COMMAND = "done";
    public static final String TODO_COMMAND = "todo";
    public static final String DEADLINE_COMMAND = "deadline";
    public static final String EVENT_COMMAND = "event";
    public static final String DELETE_COMMAND = "delete";
    private static Ui ui;
    private static TaskList tasks;
    private static Parser parser;
    public static boolean isProgramRunning = true;



    public static void main(String[] args) {
        ui = new Ui();
        tasks = new TaskList();
        parser = new Parser();
        ui.printIntroMessage();
        while (isProgramRunning) {
            String command = parser.getCommand();
            String commandType = parser.getCommandType(command);
            String commandTask = parser.getCommandTask(command);


            try {
                switch (commandType) {
                case (BYE_COMMAND):
                    isProgramRunning = false;
                    ui.printGoodbyeMessage();
                    break;
                case (LIST_COMMAND):
                    ui.printList(tasks);
                    break;

                case (DONE_COMMAND):
                    int index = parser.indexOfTask(command);
                    tasks.doneCommand(command, index);
                    break;

                case (TODO_COMMAND):
                case (DEADLINE_COMMAND):
                case (EVENT_COMMAND):
                    Task taskAdded = tasks.addCommand(commandType, command, commandTask);
                    ui.printAddedNote(taskAdded);
                    break;
                case (DELETE_COMMAND):
                    index = parser.indexOfTask(command);
                    Task taskDeleted = tasks.deleteCommand(command, index);
                    ui.printDeletedFromList(tasks, taskDeleted);
                    break;
                default:
                    throw new InvalidCommandException();
                    //
                }
            } catch (NullCommandException e) {
                ui.printNullCommandMessage(commandType);
            } catch (InvalidCommandException e) {
                ui.printInvalidCommandMessage();
            }
        }
    }
}


