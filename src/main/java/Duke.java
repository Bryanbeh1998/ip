
import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static final String BYE_COMMAND = "bye";
    public static final String LIST_COMMAND = "list";
    public static final String DONE_COMMAND = "done";
    public static final String TODO_COMMAND = "todo";
    public static final String DEADLINE_COMMAND = "deadline";
    public static final String EVENT_COMMAND = "event";
    public static final String DELETE_COMMAND = "delete";

    public static ArrayList<Task> taskList = new ArrayList<>();
    public static boolean isProgramRunning = true;
    public static int taskCount = 0;

    public static void main(String[] args) throws InvalidCommandException {

        printIntroMessage();

        while (isProgramRunning) {

            String command = getCommand();
            String commandTask = getCommandTask(command);
            String commandType = getCommandType(command);

            try {
                switch (commandType) {
                case (BYE_COMMAND):
                    isProgramRunning = false;
                    printGoodbyeMessage();
                    break;

                case (LIST_COMMAND):
                    printList(taskList, taskCount);
                    break;

                case (DONE_COMMAND):
                    doneCommand(taskList, command);
                    break;

                case (TODO_COMMAND):
                    taskCount = todoCommand(taskList, taskCount, commandTask, commandType);
                    break;

                case (DEADLINE_COMMAND):
                    taskCount = deadlineCommand(taskList, taskCount, commandTask, command);
                    break;

                case (EVENT_COMMAND):
                    taskCount = eventCommand(taskList, taskCount, commandTask, commandType);
                    break;
                case (DELETE_COMMAND):
                    taskCount = deleteCommand(taskList, taskCount, command);
                    break;

                default:
                    throw new InvalidCommandException("SORRY I DO NOT UNDERSTAND THIS");
                }
            } catch (NullCommandException e) {
                printNullCommandMessage(commandType);
            }
        }
    }


    private static void printIntroMessage() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        printLine();
        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?\n");
        printLine();
    }

    private static void printGoodbyeMessage() {
        System.out.println("Bye! Hope to see you again");
    }


    private static void printDeleted(ArrayList<Task> taskList, int taskCount, String command, int index) {
        System.out.println("NOTED. I HAVE REMOVED THIS TASK FROM YOUR LIST: \n");
        System.out.println(taskList.get(index).toString());
        System.out.println("NOW YOU ONLY HAVE " + taskCount + " TASKS IN YOUR LIST!");
    }

    private static void printNullCommandMessage(String commandType) {
        System.out.println(":( OOPS! The description of " + commandType + "cannot be empty!");
    }

    private static void printLine() {
        System.out.println("---------------------------");
    }

    private static void printList(ArrayList<Task> taskList, int taskCount) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + taskList.get(i).toString());
        }
    }

    private static String getCommandType(String command) {

        String commandType;

        if (command.contains(" ")) {

            int indexOfSpace = command.indexOf(" ");
            commandType = command.substring(0, indexOfSpace);

        } else {
            commandType = command;
        }
        return commandType;
    }

    private static String getCommandTask(String command) {
        int indexOfSpace = command.indexOf(" ");
        String commandTask = command.substring(indexOfSpace + 1);

        return commandTask;
    }

    public static String getCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void doneCommand(ArrayList<Task> taskList, String command) {
        int index = indexOfTask(command);
        taskList.get(index).markAsDone();

        System.out.println("Nice! I've marked this task as done:" + taskList.get(index).toString());
    }

    public static int todoCommand(ArrayList<Task> taskList, int taskCount, String commandTask, String commandType) throws NullCommandException {
        int counter = taskCount;
        if (commandTask == null) {
            throw new NullCommandException();
        } else {
            taskList.add(new Todo(commandTask));
        }


        System.out.println("Got it. I've add this task:" + taskList.get(taskCount).toString());
        taskCount++;
        return taskCount;
    }


    public static int deadlineCommand(ArrayList<Task> taskList, int taskCount, String commandTask, String commandType) throws NullCommandException {

        if (commandTask == null) {
            throw new NullCommandException();
        } else {
            int indexOfSlash = commandTask.indexOf("/");
            String task = commandTask.substring(0, indexOfSlash - 1);
            String by = commandTask.substring(indexOfSlash + 4);

            taskList.add(new Deadline(task, by));
        }

        System.out.println("Got it. I've added this task:" + taskList.get(taskCount).toString());
        taskCount++;
        return taskCount;
    }

    public static int eventCommand(ArrayList<Task> taskList, int taskCount, String commandTask, String commandType) throws NullCommandException {

        if (commandTask == null) {
            throw new NullCommandException();
        } else {
            int indexOfSlash = commandTask.indexOf("/");
            String event = commandTask.substring(0, indexOfSlash - 1);
            String by = commandTask.substring(indexOfSlash + 4);
            taskList.add(new Event(event, by));
        }


        System.out.println("Got it. I've add this task:" + taskList.get(taskCount).toString());
        taskCount++;
        return taskCount;
    }

    public static int deleteCommand(ArrayList<Task> taskList, int taskCount, String command) {
        int index = indexOfTask(command);
        if (index <= taskCount) {
            taskList.remove(index);
            taskCount--;
            printDeleted(taskList, taskCount, command, index);
        }
        return taskCount;
    }

    public static int indexOfTask(String command) {
        int dividerPosition = command.indexOf(" ");
        String substring = command.substring(dividerPosition + 1);
        return (Integer.parseInt(substring) - 1);
    }

}


