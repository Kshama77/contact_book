import java.util.ArrayList;
import java.util.Scanner;

public class ContactBook {
    private static final ArrayList<Contact> contacts = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("=================================");
        System.out.println("       Welcome to ContactBook");
        System.out.println("=================================");

        while (running) {
            showMenu();
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addContact();
                    break;
                case "2":
                    viewContacts();
                    break;
                case "3":
                    updateContact();
                    break;
                case "4":
                    deleteContact();
                    break;
                case "5":
                    running = false;
                    System.out.println("Thank you for using ContactBook!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println("\n----- ContactBook Menu -----");
        System.out.println("1. Add Contact");
        System.out.println("2. View Contacts");
        System.out.println("3. Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }

    private static void addContact() {
        System.out.println("\n--- Add Contact ---");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        contacts.add(new Contact(name, phone, email));
        System.out.println("Contact added successfully!");
    }

    private static void viewContacts() {
        System.out.println("\n--- Contact List ---");

        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }

        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + ". " + contacts.get(i));
        }
    }

    private static void updateContact() {
        System.out.println("\n--- Update Contact ---");

        if (contacts.isEmpty()) {
            System.out.println("No contacts to update.");
            return;
        }

        viewContacts();

        System.out.print("Enter contact number to update: ");
        int index = readNumber() - 1;

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        Contact contact = contacts.get(index);

        System.out.print("Enter new name: ");
        contact.setName(scanner.nextLine());

        System.out.print("Enter new phone: ");
        contact.setPhone(scanner.nextLine());

        System.out.print("Enter new email: ");
        contact.setEmail(scanner.nextLine());

        System.out.println("Contact updated successfully!");
    }

    private static void deleteContact() {
        System.out.println("\n--- Delete Contact ---");

        if (contacts.isEmpty()) {
            System.out.println("No contacts to delete.");
            return;
        }

        viewContacts();

        System.out.print("Enter contact number to delete: ");
        int index = readNumber() - 1;

        if (index < 0 || index >= contacts.size()) {
            System.out.println("Invalid contact number.");
            return;
        }

        contacts.remove(index);
        System.out.println("Contact deleted successfully!");
    }

    private static int readNumber() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
