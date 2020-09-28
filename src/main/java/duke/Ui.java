package duke;


import java.util.Scanner;
import java.util.ArrayList;

import duke.tasks.Task;

/**
 * Ui of application
 */
public class Ui {
    //constants

    public static final String MESSAGE_GOODBYE = "Bye! Hope to see you again";
    public static final String MESSAGE_ADDED_TASK = "Got it. I've added this task:";
    public static final String MESSAGE_INVALID_COMMAND = "Sorry but this command cannot be accepted!";
    public static final String MESSAGE_NULL_COMMAND_P1 = ":( OOPS! The description of ";
    public static final String MESSAGE_NULL_COMMAND_P2 = " cannot be empty!";
    public static final String MESSAGE_LINE = "---------------------------";
    public static final String MESSAGE_DELETED_P1 = "Noted! i have removed this task from your list: ";
    public static final String MESSAGE_DELETED_P2 = "Now only you have ";
    public static final String MESSAGE_DELETED_P3 = " task(s) in your list";

    /**
     * Takes in input entered by user
     * @return  user input entered by user
     */
    public String getCommand() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    /**
     * Prints the introduction message when Duke is booted up
     */
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

    /**
     * Prints goodbye message when the system is exited
     */
    public void printGoodbyeMessage() {
        System.out.println(MESSAGE_GOODBYE);
    }

    /**
     * Prints the task that was added to the task list
     * @param task task that was added to the task list
     */
    public void printAddedNote(Task task){
        System.out.println(MESSAGE_ADDED_TASK + task.toString());
    }

    public void printFileErrorMessage() {
        System.out.println("Something went wrong when saving");
    }

    /**
     * prints invalid command message when given an invalid command
     */
    public void printInvalidCommandMessage() {
        System.out.println(MESSAGE_INVALID_COMMAND);
    }

    /**
     * print null command message when given an empty command task
     * @param commandType command type of the command (eg Todo,Deadline,Event)
     */
    public void printNullCommandMessage(String commandType) {
        System.out.println(MESSAGE_NULL_COMMAND_P1 + commandType + MESSAGE_NULL_COMMAND_P2);
    }

    /**
     * prints a line
     */
    public void printLine() {
        System.out.println(MESSAGE_LINE);
    }

    /**
     * prints the full task list
     * @param tasks Task list of tasks
     */
    public void printList(TaskList tasks) {
        System.out.println("Here are the tasks in your list:");
        for (int i = 0; i < tasks.getTaskList().size() ; i++) {
            System.out.println((i + 1) + "." + tasks.getTaskList().get(i).toString());
        }
    }

    /**
     * print task that was deleted from the task list
     * @param tasks Task list of tasks
     * @param taskDeleted task that has been deleted from text
     */
    public void printDeletedFromList(TaskList tasks, Task taskDeleted) {
        System.out.println(MESSAGE_DELETED_P1+ taskDeleted.toString());
        System.out.println(MESSAGE_DELETED_P2 + tasks.getTaskList().size() + MESSAGE_DELETED_P3);
    }
}
