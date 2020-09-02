
import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {

        introMessage();
        Task[] taskList = new Task[100];
        int taskCount = 0;

        while (true) {
            String command = getCommand();

            if (command.equals("bye")) {
                goodbyeMessage();
                break;

            } else if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                printList(taskList, taskCount);

            } else if (command.startsWith("done")) {
                int index = doneIndex(command);
                taskList[index].markAsDone();
                System.out.println("Nice! I've marked this task as done:" + taskList[index].toString());

            } else if (command.startsWith("todo")) {
                taskCount = todoCommand(taskList, taskCount, command);

            } else if (command.startsWith("deadline")) {
                taskCount = deadlineCommand(taskList, taskCount, command);

            }else if (command.startsWith("event")){
                taskCount = eventCommand(taskList,taskCount,command);

            }else{
                for (Task task: taskList) {
                    taskList[taskCount] = new Task(command);
                }
                System.out.println("added:" + taskList[taskCount].toString());
                taskCount++;
            }
            printLine();
        }
    }

    private static void introMessage(){
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
    private static void goodbyeMessage() {
        System.out.println("Bye! Hope to see you again");
    }
    private static void printLine(){
        System.out.println("---------------------------");
    }
    private static void printList(Task[] taskList, int taskCount) {
        for (int i = 0; i < taskCount; i++) {
            System.out.println((i + 1) + "." + taskList[i].toString());
        }
    }

    public static String getCommand(){
        Scanner input  = new Scanner(System.in);
        return input.nextLine();
    }
    public static int todoCommand(Task[] taskList, int taskCount,String command) {
        int indexOfSpace = command.indexOf(" ");
        String substringOfCommand = command.substring(indexOfSpace + 1);
        for (Task task : taskList) {
            taskList[taskCount] = new Todo(substringOfCommand);
        }
        System.out.println("Got it. I've add this task:" + taskList[taskCount].toString());
        taskCount++;
        return taskCount;
    }
    public static int deadlineCommand(Task[] taskList, int taskCount, String command){
        int indexOfSpace = command.indexOf(" ");
        int indexOfSlash = command.indexOf("/");

        String substringOfCommand = command.substring(indexOfSpace + 1, indexOfSlash - 1);
        String substringOfBy = command.substring(indexOfSlash + 4);

        for (Task task : taskList) {
            taskList[taskCount] = new Deadline(substringOfCommand,substringOfBy);
        }

        System.out.println("Got it. I've add this task:" + taskList[taskCount].toString());
        taskCount++;
        return taskCount;
    }
    public static int eventCommand(Task[] taskList , int taskCount, String command){
        int indexOfSpace = command.indexOf(" ");
        int indexOfSlash = command.indexOf("/");

        String substringOfCommand = command.substring(indexOfSpace + 1, indexOfSlash - 1);
        String substringOfAt = command.substring(indexOfSlash + 4);

        for (Task task : taskList){
            taskList[taskCount] = new Event(substringOfCommand,substringOfAt);
        }

        System.out.println("Got it. I've add this task:" + taskList[taskCount].toString());
        taskCount++;
        return taskCount;
    }


    public static int doneIndex(String command){
        int dividerPosition = command.indexOf(" ");
        String substring = command.substring(dividerPosition + 1);
        return (Integer.parseInt(substring) - 1);
    }
}


