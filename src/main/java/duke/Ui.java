package duke;


import java.util.Scanner;
import java.util.ArrayList;

import duke.tasks.Task;

public class Ui {
    //constants
    public static final String BYE_COMMAND = "bye";
    public static final String LIST_COMMAND = "list";
    public static final String DONE_COMMAND = "done";
    public static final String TODO_COMMAND = "todo";
    public static final String DEADLINE_COMMAND = "deadline";
    public static final String EVENT_COMMAND = "event";
    public static final String DELETE_COMMAND = "delete";
    public static final String MESSAGE_GOODBYE = "Bye! Hope to see you again";
    public static final String MESSAGE_ADDED_TASK = "Got it. I've added this task:";
    public static final String MESSAGE_INVALID_COMMAND = "Sorry but this command cannot be accepted!";
    public static final String MESSAGE_NULL_COMMAND_P1 = ":( OOPS! The description of ";
    public static final String MESSAGE_NULL_COMMAND_P2 = " cannot be empty!";
    public static final String MESSAGE_LINE = "---------------------------";
    public static final String MESSAGE_DELETED_P1 = "Noted! i have removed this task from your list: ";
    public static final String MESSAGE_DELETED_P2 = "Now only you have ";
    public static final String MESSAGE_DELETED_P3 = " task(s) in your list";
    public static String getCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public void printIntroMessage() {
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

    public void printGoodbyeMessage() {
        System.out.println(MESSAGE_GOODBYE);
    }

    public void printAddedNote(Task task){
        System.out.println(MESSAGE_ADDED_TASK + task.toString());
    }

    public void printFileErrorMessage() {
        System.out.println("Something went wrong when saving");
    }

    public void printInvalidCommandMessage() {
        System.out.println(MESSAGE_INVALID_COMMAND);
    }

    public void printNullCommandMessage(String commandType) {
        System.out.println(MESSAGE_NULL_COMMAND_P1 + commandType + MESSAGE_NULL_COMMAND_P2);
    }

    public void printLine() {
        System.out.println(MESSAGE_LINE);
    }

    public void printList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.getTaskList().size() ; i++) {
            System.out.println((i + 1) + "." + tasks.getTaskList().get(i).toString());
        }
    }

    public void printDeletedFromList(TaskList tasks, Task taskDeleted) {
        System.out.println(MESSAGE_DELETED_P1+ taskDeleted.toString());
        System.out.println(MESSAGE_DELETED_P2 + tasks.getTaskList().size() + MESSAGE_DELETED_P3);
    }
}
