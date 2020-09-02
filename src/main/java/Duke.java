
import java.util.Scanner;




public class Duke {
    public static void main(String[] args) {
        introMessage();

        Task[] taskList = new Task[100];
        int taskCount = 0;

        while (true){
            String command = getCommand();

            if (command.equals("bye")){
                System.out.println("Bye! Hope to see you again");
                break;
            }

            else if (command.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i =0; i<taskCount;i++) {
                    System.out.println((i + 1) + "." + taskList[i].toString());

                }
            }
            else if(command.startsWith("done")) {

                int index = doneIndex(command);
                taskList[index].markAsDone();
                System.out.println("Nice! I've marked this task as done:" + taskList[index].toString());
            }

            else {
                for (Task task: taskList) {
                    taskList[taskCount] = new Task(command);
                }
                System.out.println("added:" + taskList[taskCount].toString());
                taskCount++;
            }
        }
    }

    private static void introMessage(){
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?\n");
    }

    public static String getCommand(){
        Scanner input  = new Scanner(System.in);
        return input.nextLine();
    }

    public static int doneIndex(String command){
        int dividerPosition = command.indexOf(" ");
        String substring = command.substring(dividerPosition + 1);
        return (Integer.parseInt(substring) - 1);
    }
}

