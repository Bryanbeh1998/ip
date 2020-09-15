import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Duke {
    //constants
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
        File f = new File("list/data.txt");


        while (isProgramRunning) {

            String command = getCommand();
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
                case (DEADLINE_COMMAND):
                case (EVENT_COMMAND):
                    taskCount = addCommand(taskList, taskCount,commandType,command);
                    break;
                case (DELETE_COMMAND):
                    taskCount = deleteCommand(taskList, taskCount, command);
                    break;
                default :
                    throw new InvalidCommandException("SORRY BUT THIS COMMAND CANNOT BE ACCEPTED!");
                    //System.out.print("TOUGH, I DO NOT KNOW WHAT IS THAT COMMAND!\n");
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

    private static void printAddedNote(ArrayList<Task> taskList, int taskCount){
        System.out.println("Got it. I've added this task:" + taskList.get(taskCount).toString());
    }

    private static void printDeleted(ArrayList<Task> taskList, int taskCount, int index) {
        System.out.println("Noted! I have removed this task from your list: ");
        System.out.println(taskList.get(index).toString());
        System.out.println("Now only you have " + taskCount + " task(s) in your list");
    }

    private static void printNullCommandMessage(String commandType) {
        System.out.println(":( OOPS! The description of " + commandType + " cannot be empty!");
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
        String[] arr = command.split(" ");

        if (command.contains(" ")) {

            commandType = arr[0];
        } else {
            commandType = command;
        }
        return commandType;
    }

    private static String getCommandTask(String command) {

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


    public static String getCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void doneCommand(ArrayList<Task> taskList, String command) {
        int index = indexOfTask(command);
        taskList.get(index).markAsDone();

        System.out.println("Nice! I've marked this task as done:" + taskList.get(index).toString());
    }

    public static int addCommand(ArrayList<Task> taskList, int taskCount, String commandType, String command) throws NullCommandException {
        String commandTask = getCommandTask(command);
        String fileName = "list/data.txt";


        if (commandTask == null) {
            throw new NullCommandException();

        }else if (commandType.equals(TODO_COMMAND) && commandTask != null) {
            taskList.add(new Todo(commandTask));

        } else if (commandType.equals(DEADLINE_COMMAND) && commandTask != null) {
            int indexOfSlash = commandTask.indexOf("/");
            String task = commandTask.substring(0, indexOfSlash - 1);
            String by = commandTask.substring(indexOfSlash + 4);
            taskList.add(new Deadline(task, by));

        } else if (commandType.equals(EVENT_COMMAND) && commandTask != null) {
            int indexOfSlash = commandTask.indexOf("/");
            String event = commandTask.substring(0, indexOfSlash - 1);
            String by = commandTask.substring(indexOfSlash + 4);
            taskList.add(new Event(event, by));
        }
        printAddedNote(taskList,taskCount);
        taskCount++;
        return taskCount;
    }

    public static int deleteCommand(ArrayList<Task> taskList, int taskCount, String command) {
        int index = indexOfTask(command);
        if (index <= taskCount) {
            taskList.remove(index);
            taskCount--;
            printDeleted(taskList, taskCount, index);
        }
        return taskCount;
    }

    public static int indexOfTask(String command) {
        int dividerPosition = command.indexOf(" ");
        String substring = command.substring(dividerPosition + 1);
        return (Integer.parseInt(substring) - 1);
    }

    public static void writeToFile(String filename, ArrayList<Task> taskList) throws IOException {
        FileWriter fw = new FileWriter(filename);
        fw.write(String.valueOf(taskList));
        fw.close();
    }
}


