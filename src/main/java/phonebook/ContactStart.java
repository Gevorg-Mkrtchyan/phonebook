package phonebook;

import phonebook.domain.Contact;
import phonebook.service.impl.ContactServiceImpl;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactStart {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        ContactServiceImpl service = new ContactServiceImpl();
        Set<Contact> contacts = new HashSet<>();
        System.out.println("Welcome Phone Book");
        System.out.println("Please follow to command");
        while (true) {
            System.out.println("press 1 for adding contact");
            System.out.println("press 2 for deleting contact");
            System.out.println("press 3 for editing contact");
            System.out.println("press 4 for getting by contact's phoneNumber");
            System.out.println("press 5 for getting by contact's name");
            System.out.println("press 6 for getting all contacts");
            System.out.println("press 7 for deleting contact by Id");
            System.out.println("press 0 for exit phone book");
            command = scanner.next();
            switch (command) {
                case "1": {
                    final boolean isAdded = service.addContact(contacts);
                    if (isAdded) {
                        System.out.println("You successfully add contact");
                    } else {
                        System.out.println("Sorry sometimes went wrong");
                    }
                    break;
                }
                case "2": {
                    final boolean isDeleted = service.delete(contacts);
                    if (isDeleted) {
                        System.out.println("Contact is deleted");
                    } else {
                        System.out.println("this contact can not be deleted");
                    }
                    break;
                }
                case "3": {
                    final Contact contact = service.editeContact(contacts);
                    if (contact != null) {
                        System.out.println("Contact is edited");
                    } else {
                        System.out.println("this contact can not be edited");
                    }
                    break;
                }
                case "4": {
                    final Set<Contact> byPhoneNumber = service.getByPhoneNumber(contacts);
                    if (byPhoneNumber.size() > 0) {
                        service.getAllContacts(byPhoneNumber);
                    } else {
                        System.out.println("There is no contact by this phone number");
                    }
                    break;
                }
                case "5": {
                    final Set<Contact> byFirstNameAndLastName = service.getByNameAndLastName(contacts);
                    if (byFirstNameAndLastName.size() > 0) {
                        service.getAllContacts(byFirstNameAndLastName);
                    } else {
                        System.out.println("There is no contact with this firstName and lastName");
                    }
                    break;
                }
                case "6": {
                    service.getAllContacts(contacts);
                    break;
                }
                case "7": {
                    service.deleteContactById(contacts);
                    break;
                }
                case "0": {
                    ContactServiceImpl.SystemExit();
                    break;
                }
                default: {
                    System.out.println("You ara enter wrong command");
                }
            }
        }
    }
}

