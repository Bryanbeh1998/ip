package duke;

import duke.exceptions.NullCommandException;
import duke.tasks.Todo;
import duke.tasks.Task;
import duke.tasks.Event;
import duke.tasks.Deadline;

import java.util.ArrayList;

/**
 * Task list to store data for application
 */
public class TaskList {

    public static final String TODO_COMMAND = "todo";
    public static final String DEADLINE_COMMAND = "deadline";
    public static final String EVENT_COMMAND = "event";
    public static final String SLASH_DIVIDER = "/";
    public ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }

    /**
     * Marks a task as done
     * @param index index of task to be marked as done
     */
    public void doneCommand(int index) {
        taskList.get(index).markAsDone();
        System.out.println("Nice! I've marked this task as done:" + taskList.get(index).toString());
    }

    /**
     * Adds either Todo,Deadline or Event to Task list
     * @param commandType String of the type of command (eg Todo,Deadline,Event)
     * @param commandTask String of the task of the command
     * @return Task Task that was added to the list
     * @throws NullCommandException throws exception when there is no command task
     */
    public Task addCommand(String commandType, String commandTask) throws NullCommandException {
        Task taskAdded = null;
        if (commandTask == null) {
            throw new NullCommandException();
        } else if (commandType.equals(TODO_COMMAND)) {
            taskAdded = new Todo(commandTask);
            taskList.add(taskAdded);
        } else if (commandType.equals(DEADLINE_COMMAND)) {
            int indexOfSlash = commandTask.indexOf(SLASH_DIVIDER);
            String task = commandTask.substring(0, indexOfSlash - 1);
            String by = commandTask.substring(indexOfSlash + 4);
            taskAdded = new Deadline(task, by);
            taskList.add(taskAdded);
        } else if (commandType.equals(EVENT_COMMAND)) {
            int indexOfSlash = commandTask.indexOf(SLASH_DIVIDER);
            String event = commandTask.substring(0, indexOfSlash - 1);
            String by = commandTask.substring(indexOfSlash + 4);
            taskAdded = new Event(event, by);
            taskList.add(taskAdded);
        }

        return taskAdded;
    }

    /**
     * Deletes a task from the task list
     * @param index index of task to be deleted
     * @return task that was deleted
     */
    public Task deleteCommand(int index) {
        Task taskDeleted = taskList.get(index);
        taskList.remove(index);
        return taskDeleted;
    }

    /**
     * Returns a list of tasks with the specified keyword the user entered
     * @param commandTask keyword to search through the list with
     */
    public void findCommand(String commandTask) {
        ArrayList<Task> searchList = new ArrayList<>();

        for (int i=0; i < taskList.size();i++) {
            if (taskList.get(i).getDescription().contains(commandTask)) {
                Task taskToAdd = taskList.get(i);
                searchList.add(taskToAdd);
            }
        }
        for (int i = 0; i < searchList.size(); i++) {
            System.out.println((i + 1) + "." + searchList.get(i).toString());
        }

    }

    public void printNumOfTasksInList(TaskList tasks) {
        System.out.println("Now you have " + taskList.size() + " task(s) in your list!");
    }
}
