package academy.learnprogramming;
import java.util.Scanner;

public class MobilePhone {
    private static Scanner sc = new Scanner(System.in);
    private static Contacts contacts = new Contacts();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        contacts.printOptions();
        while(!quit) {
            System.out.println("Enter option: \r");
            choice = sc.nextInt();
            switch(choice) {
                case 0:
                    contacts.printOptions();
                    break;
                case 1:
                    contacts.accessAdd();
                    break;
                case 2:
                    contacts.instructions();
                    System.out.println("Enter path: \r");
                    int choice2 = sc.nextInt();
                    switch(choice2) {
                        case 1:
                            contacts.accessFind();
                            break;
                        case 2:
                            contacts.accessNum();
                            break;
                    }
                    break;
                case 3:
                    contacts.accessRemove();
                    break;
                case 4:
                    contacts.accessPrint();
                    break;
                case 5:
                    contacts.accessUpdate();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    quit = true;
            }
        }
    }

}
