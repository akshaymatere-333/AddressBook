//TASK 4 - Write a basic CRUD application :
//Develop a basic CRUD application that allows users to perfrom CRUD operations.


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber;
    }
}

public class AddressBook {
    private List<Contact> contacts;

    public AddressBook() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    public Contact getContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equalsIgnoreCase(name)) {
                return contact;
            }
        }
        return null;
    }

    public void updateContact(Contact contact) {
        Contact existingContact = getContactByName(contact.getName());
        if (existingContact != null) {
            existingContact.setPhoneNumber(contact.getPhoneNumber());
        } else {
            System.out.println("Contact not found!");
        }
    }

    public void deleteContact(String name) {
        Contact contact = getContactByName(name);
        if (contact != null) {
            contacts.remove(contact);
        } else {
            System.out.println("Contact not found!");
        }
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty!");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nAddress Book");
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter phone number: ");
                    String phoneNumber = scanner.nextLine();
                    Contact newContact = new Contact(name, phoneNumber);
                    addressBook.addContact(newContact);
                    System.out.println("Contact added successfully!");
                    break;
                case 2:
                    System.out.println("\nContacts:");
                    addressBook.displayContacts();
                    break;
                case 3:
                    System.out.print("Enter the name of the contact to update: ");
                    String updateName = scanner.nextLine();
                    Contact updatedContact = addressBook.getContactByName(updateName);
                    if (updatedContact != null) {
                        System.out.print("Enter new phone number: ");
                        String newPhoneNumber = scanner.nextLine();
                        updatedContact.setPhoneNumber(newPhoneNumber);
                        System.out.println("Contact updated successfully!");
                    } else {
                        System.out.println("Contact not found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter the name of the contact to delete: ");
                    String deleteName = scanner.nextLine();
                    addressBook.deleteContact(deleteName);
                    System.out.println("Contact deleted successfully!");
                    break;
                case 5:
                    System.out.println("Exiting the Address Book application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
