package academy.learnprogramming;
import java.util.Scanner;
import java.util.ArrayList;

public class Contacts {

    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<String> listOfContacts = new ArrayList<>();
    private static ArrayList<String> phoneNumbers = new ArrayList<>();

    private void addContact() {
        System.out.println("Enter name: ");
        String name = sc.nextLine();
        int position = findContactByNameForAdding(name);
        String phoneNumber = "";
        if(position >= 0) {
            System.out.println("Cannot add contact as contact already exists.");
        }else {
            if(listOfContacts.contains(name)) {
                System.out.println("Contact already exists.");
            }else {
                listOfContacts.add(name);
                System.out.println("Enter phone number: ");
                phoneNumber = sc.nextLine();
                String name2 =  phoneNumber.replaceAll("\\s","");
                int position2 = findContactByNumber(name2);
                if(position2 >= 0) {
                    System.out.println("Contact exists with current number.");
                    System.out.println("Contact: " + listOfContacts.get(phoneNumbers.indexOf(name2)));
                }else {
                    phoneNumbers.add(phoneNumber);
                    System.out.println("Added contact.");
                }
            }
        }
    }


    private int findContactByNameForAdding(String name) {
        if(listOfContacts.contains(name)) {
            System.out.println("Contact already exists.");
            System.out.println("Contact: \n" + listOfContacts.get(listOfContacts.indexOf(name)));
            System.out.println(phoneNumbers.get(listOfContacts.indexOf(name)));
        }else if(phoneNumbers.contains(name)) {
            System.out.println("Number associated with another contact.");
            System.out.println("Contact: \n" + listOfContacts.get(listOfContacts.indexOf(name)));
        }

        return listOfContacts.indexOf(name);
    }

    private int findContactByNameForSearching(String name) {
        if(listOfContacts.contains(name)) {
            System.out.println("Contact: \n" + listOfContacts.get(listOfContacts.indexOf(name)));
            System.out.println(phoneNumbers.get(listOfContacts.indexOf(name)));
        }else if(phoneNumbers.contains(name)){
            System.out.println("Number associated with another contact.");
            System.out.println("Contact: \n" + listOfContacts.get(listOfContacts.indexOf(name)));
        }else if(!phoneNumbers.contains(listOfContacts.indexOf(name)) && !listOfContacts.contains(name)){
            System.out.println("No contact matched with name: " + name);
        }

        return listOfContacts.indexOf(name);
    }

    private int findContactByNumber(String number) {
        if(phoneNumbers.contains(number)) {
            System.out.println("Contact: \n" + listOfContacts.get(phoneNumbers.indexOf(number)));
            System.out.println(phoneNumbers.get(phoneNumbers.indexOf(number)));
        }else {
            System.out.println("No matching contact.");
        }
        return phoneNumbers.indexOf(number);
    }

    private void removeContact(String name) {
        if(listOfContacts.contains(name)) {
            System.out.println("Removed contact.");
            phoneNumbers.remove(listOfContacts.indexOf(name));
            listOfContacts.remove(name);
        }else {
            System.out.println("Contact does not exist.");
        }
    }

    private void printContactList() {
        if(listOfContacts.isEmpty() && phoneNumbers.isEmpty()) {
            System.out.println("Contact list is empty.");
        }else {
            for(int i=0; i<listOfContacts.size(); i++) {
                System.out.print("Contact list: \n");
                System.out.println((i+1) + ". " + listOfContacts.get(i) + ", Phone number: " + phoneNumbers.get(i));
            }
        }
    }

    private void updateExistingContact(String name) {
        int position = findContactByNameForSearching(name);
        if(position < 0) {
            System.out.println("No existing contact to modify.");
        }else if(listOfContacts.contains(name)){
            System.out.println("Enter updated name:");
            String updatedName = sc.nextLine();
            if(listOfContacts.contains(updatedName)) {
                System.out.println("Cannot update contact as a contact already exists with current name.");
            }else {
                System.out.println("Enter updated number:");
                String updatedNumber = sc.nextLine();
                System.out.println("Updating existing contact: " + listOfContacts.get(position) + " to " + updatedName);
                listOfContacts.set(position, updatedName);
                phoneNumbers.set(position, updatedNumber);
            }
        }
    }

    public void printOptions() {
        System.out.println("\nPress");
        System.out.println("\t 0 - To show available options.");
        System.out.println("\t 1 - To add a contact.");
        System.out.println("\t 2 - To search for a contact.");
        System.out.println("\t 3 - To remove a contact.");
        System.out.println("\t 4 - To show all current contacts.");
        System.out.println("\t 5 - To update an existing contact.");
        System.out.println("\t 6 - To exit.");
    }

    public void instructions() {
        System.out.println("\nPress");
        System.out.println("\t 1 - To search by name.");
        System.out.println("\t 2 - To search by number.");
    }

    public void accessAdd() {
        addContact();
    }

    public void accessFind() {
        System.out.println("Enter name of contact: \r");
        String name = sc.nextLine();
        findContactByNameForSearching(name);
    }

    public void accessRemove() {
        System.out.println("Enter contact name to remove: \r");
        String name = sc.nextLine();
        removeContact(name);
    }

    public void accessPrint() {
        printContactList();
    }

    public void accessUpdate() {
        System.out.println("Enter contact name to update: \r");
        String name = sc.nextLine();
        updateExistingContact(name);

    }
    public void accessNum() {
        System.out.println("Enter number: \r");
        String number = sc.nextLine();

        findContactByNumber(number);
    }

}
