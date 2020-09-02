
import java.net.Inet4Address;
import java.util.Scanner;
import java.util.ArrayList;



public class Duke {
    public static void main(String[] args) {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("Hello! I'm Duke");
        System.out.println("What can i do for you?\n");

        Scanner input = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        int i = 1;

        while (true){
            String words = input.nextLine();
            Task t = new Task(words);

            if (t.description.equals("bye")){
                System.out.println("Bye! Hope to see you again");
                break;
            }

            else if (t.description.equals("list")) {

                System.out.println("Here are the tasks in your list:");
                for (String s : list) {
                    System.out.println(s);
                }
            }
            else if(t.description.contains("done")){
                t.setAsDone();
                System.out.println("Nice! I've marked this task as done");
                String taskNumberString = t.description.replaceAll("[^0-9]",""); //extract the int
                int taskNumber = Integer.parseInt(taskNumberString);    //convert string to int

                String doneTask = list.get(taskNumber-1);   //extract the task that is done
                int dividerPosition = doneTask.indexOf("\u2718");
                String justTask = doneTask.substring(dividerPosition + 1,doneTask.length()); //remove the number and symbol

                System.out.println(taskNumber + "." + t.getStatusIcon() + justTask); //print out the task that is done

                list.set(taskNumber-1, (taskNumber)+ "." + t.getStatusIcon() + justTask);   //update the list
            }
            else {
                list.add(i+ "." + t.getStatusIcon()+ words);
                System.out.println("added: " + words);
                i++;
            }
        }
    }
}
