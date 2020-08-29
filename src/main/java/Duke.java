import java.util.Scanner;

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
        
        while (true){
            Scanner input = new Scanner(System.in);
            String word = input.next();
            if (word.equals("bye")){
                System.out.println("Bye! Hope to see you again");
                break;
            }
            else{
                System.out.println(word);
                continue;
            }
        }
    }
}
