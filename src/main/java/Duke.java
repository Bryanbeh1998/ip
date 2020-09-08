
import java.util.Scanner;


public class Duke {

    public static final String BYE_COMMAND = "bye";
    public static final String LIST_COMMAND = "list";
    public static final String DONE_COMMAND = "done";
    public static final String TODO_COMMAND = "todo";
    public static final String DEADLINE_COMMAND = "deadline";
    public static final String EVENT_COMMAND = "event";


    public static void main(String[] args) throws InvalidCommandException {

        printIntroMessage();

        Task[] taskList = new Task[100];
        int taskCount = 0;
        boolean isProgramRunning = true;

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

                default:
                    System.out.println("Tough, i do not know what this is!");
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

    private static void printNullCommandMessage(String commandType) {
        System.out.println(":( OOPS! The description of " + commandType + "cannot be empty!");
    }

    private static void printLine() {
        System.out.println("---------------------------");
    }

    private static void printList(Task[] taskList, int taskCount) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + taskList[i].toString());
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

    public static void doneCommand(Task[] taskList, String command) {
        int index = doneIndex(command);
        taskList[index].markAsDone();

        System.out.println("Nice! I've marked this task as done:" + taskList[index].toString());
    }

    public static int todoCommand(Task[] taskList, int taskCount, String commandTask, String commandType) throws NullCommandException {

        if (commandTask == null) {
            throw new NullCommandException();
        } else {
            for (Task task : taskList) {
                taskList[taskCount] = new Todo(commandTask);
            }

            System.out.println("Got it. I've add this task:" + taskList[taskCount].toString());
            taskCount++;
            return taskCount;
        }
    }

    public static int deadlineCommand(Task[] taskList, int taskCount, String commandTask, String commandType) throws NullCommandException {

        if (commandTask == null) {
            throw new NullCommandException();
        } else {
            int indexOfSlash = commandTask.indexOf("/");
            String task = commandTask.substring(0,indexOfSlash - 1);
            String by = commandTask.substring(indexOfSlash + 4);

            for (Task tasks : taskList) {
                taskList[taskCount] = new Deadline(task, by);
            }
        }
        System.out.println("Got it. I've added this task:" + taskList[taskCount].toString());
        taskCount++;
        return taskCount;
    }

    public static int eventCommand(Task[] taskList, int taskCount, String commandTask, String commandType) throws NullCommandException {

        if (commandTask == null) {
            throw new NullCommandException();
        } else {
            int indexOfSlash = commandTask.indexOf("/");
            String event = commandTask.substring(0,indexOfSlash - 1);
            String by = commandTask.substring(indexOfSlash + 4);
            for (Task task : taskList) {
                taskList[taskCount] = new Event(event, by);

            }
        }

        System.out.println("Got it. I've add this task:" + taskList[taskCount].toString());
        taskCount++;
        return taskCount;
    }

    public static int doneIndex(String command) {
        int dividerPosition = command.indexOf(" ");
        String substring = command.substring(dividerPosition + 1);
        return (Integer.parseInt(substring) - 1);
    }
}


