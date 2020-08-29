
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
            if (words.equals("bye")){
                System.out.println("Bye! Hope to see you again");
                break;
            }
            if (words.equals("list")) {
                for (String s : list) {

                    System.out.println(i + "." + s );
                    i++;
                }
            }
            else {
                list.add(words);
                System.out.println("added: " + words);
            }
        }
    }
}
