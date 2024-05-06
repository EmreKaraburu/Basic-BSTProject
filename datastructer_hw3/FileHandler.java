package datastructer_hw3;

//Emre Karaburu

import java.io.*;

public class FileHandler {
    public static void readContactsFromFile(String filename, BST contactBST) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] contactDetails = line.split(",");
                if (contactDetails.length == 4 && isDigitPhoneNumber(contactDetails[2])) {
                    Contact contact = new Contact(contactDetails[0], contactDetails[1],
                            contactDetails[2], contactDetails[3]);
                    contactBST.insert(contact);

                } else {
                    System.out.println("- Invalid input combination ");

                }
            }

        } catch (IOException e) {
            System.err.println("Error reading contacts from file: " + e.getMessage());
        }
    }

    public static void writeContactsToFile(String filename, BST contactBST) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            writeContactsToFileRecursive(bw, contactBST.root);
        } catch (IOException e) {
            System.err.println("Error writing contacts to file: " + e.getMessage());
        }
    }

    private static void writeContactsToFileRecursive(BufferedWriter bw, Node root) throws IOException {
        if (root != null) {
            writeContactsToFileRecursive(bw, root.left);
            bw.write(root.contact.toString());
            bw.newLine();
            writeContactsToFileRecursive(bw, root.right);
        }
    }

    private static boolean isDigitPhoneNumber(String numberString) {
        for (int i = 0; i < numberString.length(); i++) {
            if (!Character.isDigit(numberString.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}