package phonebook;

import phonebook.domain.Contact;
import phonebook.service.impl.ContactServiceImpl;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import static phonebook.service.SaveAndLoadContact.read;
import static phonebook.service.SaveAndLoadContact.write;

public class ContactStart {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command;
        String select;
        ContactServiceImpl service = new ContactServiceImpl();
        Set<Contact> contacts = new TreeSet<>();
        read(contacts);
        System.out.println("Welcome Phone Book");
        System.out.println("Please follow to command");
        while (true) {
            System.out.println("press 1 for add contact");
            System.out.println("press 2 for delete contact");
            System.out.println("press 3 for edit contact");
            System.out.println("press 4 for search contact");
            System.out.println("press 5 for get all contacts");
            System.out.println("press 0 for exit phone book");
            command = scanner.next();
            switch (command) {
                case "1" -> service.addContact(contacts);
                case "2" -> {
                    System.out.println("""
                            pass 1 for delete contact by first name and last name\s
                            pass 2 for delete contact by first name and phoneNumber
                            pass other for return main menu""");
                    select = scanner.next();
                    switch (select) {
                        case "1" -> {
                            final boolean isDeleted = service.delete(contacts);
                            if (isDeleted) {
                                System.out.println("Contact is deleted");
                            } else {
                                System.out.println("contact does not exist");
                            }
                        }
                        case "2" -> service.deleteContactByNameAndNumber(contacts);
                        default -> System.out.println("return to main menu");
                    }
                }
                case "3" -> {
                    final Contact contact = service.editeContact(contacts);
                    if (contact != null) {
                        System.out.println("Contact is edited");
                    } else {
                        System.out.println("contact does not exist");
                    }
                }
                case "4" -> {
                    System.out.println("""
                            pass 1 for search by phone number\s
                            pass 2 for search by name
                            pass other for return main menu""");
                    String selectSearch = scanner.next();
                    switch (selectSearch) {
                        case "1" -> {
                            final Set<Contact> byPhoneNumber = service.getByPhoneNumber(contacts);
                            if (byPhoneNumber.size() > 0) {
                                service.getAllContacts(byPhoneNumber);
                            } else {
                                System.out.println("There is no contact by this phone number");
                            }
                        }
                        case "2" -> {
                            final Set<Contact> byFirstNameAndLastName = service.getByNameAndLastName(contacts);
                            if (byFirstNameAndLastName.size() > 0) {
                                service.getAllContacts(byFirstNameAndLastName);
                            } else {
                                System.out.println("There is no contact with this firstName and lastName");
                            }
                        }
                        default -> System.out.println("return to main menu");
                    }
                }
                case "5" -> service.getAllContacts(contacts);
                case "0" -> {
                    write(contacts);
                    ContactServiceImpl.SystemExit();
                }
                default -> System.out.println("You are enter wrong command");
            }
        }
    }
}

