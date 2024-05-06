package datastructer_hw3;

//Emre Karaburu 

import java.util.Scanner;

public class ContactManagementSystem {

    public static void main(String[] args) {
        BST contactBST = new BST();

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Please select an option:");
            System.out.println("1. Display contacts (Preorder)");
            System.out.println("2. Display contacts (Inorder)");
            System.out.println("3. Display contacts (Postorder)");
            System.out.println("4. Search for a contact");
            System.out.println("5. Delete a contact");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.println("Displaying contacts (Preorder):");
                    FileHandler.readContactsFromFile("src/datastructer_hw3/contacts.csv", contactBST);
                    contactBST.preorder();
                }
                case 2 -> {
                    System.out.println("Displaying contacts (Inorder):");
                    FileHandler.readContactsFromFile("src/datastructer_hw3/contacts.csv", contactBST);
                    contactBST.inorder();
                }
                case 3 -> {
                    System.out.println("Displaying contacts (Postorder):");
                    FileHandler.readContactsFromFile("src/datastructer_hw3/contacts.csv", contactBST);
                    contactBST.postOrder();
                }
                case 4 -> {
                    System.out.println("Enter the last name of the contact you want to search for:");
                    String searchLastName = scanner.nextLine();
                    Contact searchedContact = contactBST.search(searchLastName);
                    if (searchedContact != null) {
                        System.out.println("Contact found:");
                        System.out.println("- " + searchedContact);
                    } else {
                        System.out.println("Contact not found!");
                    }
                }
                case 5 -> {
                    System.out.println("Enter the last name of the contact you want to delete:");
                    String deleteLastName = scanner.nextLine();
                    Contact deletedContact = contactBST.search(deleteLastName);
                    if (deletedContact != null) {
                        contactBST.delete(deleteLastName);
                        System.out.println("Contact deleted successfully!");
                        // Dosyaya güncellenmiş verileri yaz
                        FileHandler.writeContactsToFile("src/datastructer_hw3/contacts.csv", contactBST);
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                }
                case 6 -> System.out.println("Exiting and saving contact details to file...");
                default -> System.out.println("Invalid choice! Please enter a number between 1 and 6.");
            }
        } while (choice != 6);
    }
}
