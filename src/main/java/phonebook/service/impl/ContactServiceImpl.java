package phonebook.service.impl;

import phonebook.contactEnumType.EmailType;
import phonebook.contactEnumType.PhoneBookType;
import phonebook.domain.Address;
import phonebook.domain.Contact;
import phonebook.service.ContactService;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactServiceImpl extends Contact implements ContactService {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        Set<Contact> result = new HashSet<>();
        if (contacts != null) {
            System.out.println("Please enter firstName");
            String firstName = scanner.next();
            System.out.println("Please enter lastName");
            String lastName = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getFirstName().equals(firstName) && contact.getLastName().equals(lastName)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    @Override
    public Set<Contact> getByPhoneNumber(Set<Contact> contacts) {
        Set<Contact> result = new HashSet<>();
        if (contacts != null) {
            System.out.println("please enter phone number");
            String phoneNumber = scanner.next();
            for (Contact contact : contacts) {
                if (contact.getPhoneNumber().equals(phoneNumber)) {
                    result.add(contact);
                }
            }
        }
        return result;
    }

    @Override
    public Contact getContact(Contact contact, Set<Contact> contacts) {
        return null;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        if (contacts != null) {
            final Contact contact = crateContact();
            contacts.add(contact);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
        return false;
    }

    @Override
    public Contact editeContact(Set<Contact> contacts) {
        return null;
    }

    @Override
    public void getAllContacts(Set<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("contacts is empty");
        } else {
            System.out.println("print contact");
        }
        contacts.forEach(System.out::println);
    }

    @Override
    public boolean deleteContactById(Set<Contact> contacts) {
        return false;
    }

    private static Contact updatedContactToContact(Contact source, Contact destination) {
        return null;
    }

    public static Contact crateContact() {
        ArrayList<String> cont = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        System.out.println("please enter fist name, name mast be range in 3 - 15 symbols");
        contact.setFirstName(scanner.next());
        System.out.println("please enter last name, name mast be range in 6 - 20 symbols");
        contact.setLastName(scanner.next());
        System.out.println("please enter email ex qwerty@gmail.com");
        contact.setEmail(scanner.next());
        System.out.println("please enter contact type in email (1 for gmail,2 for mail,3 for yahoo, 4 for yandex)");
        int emailType = scanner.nextInt();
        switch (emailType) {
            case 1 -> contact.setEmailType(EmailType.GMAIL.getName());
            case 2 -> contact.setEmailType(EmailType.MAIL.getName());
            case 3 -> contact.setEmailType(EmailType.YAHOO.getName());
            case 4 -> contact.setEmailType(EmailType.YANDEX.getName());
            default -> System.out.println("other email type");
        }
        System.out.println("please enter phone number (+374 ******)");
        contact.setPhoneNumber(scanner.next());
        System.out.println("please enter contact type in phone book (1 for Work,2 for Mobile,3 for Home,4 for School");
        int phoneNumberType = scanner.nextInt();
        switch (phoneNumberType) {
            case 1 -> contact.setPhoneNumberType(PhoneBookType.Work.getName());
            case 2 -> contact.setPhoneNumberType(PhoneBookType.Mobile.getName());
            case 3 -> contact.setPhoneNumberType(PhoneBookType.Home.getName());
            case 4 -> contact.setPhoneNumberType(PhoneBookType.School.getName());
            default -> System.out.println("other phone type");
        }
        Address address = new Address();
        System.out.println("please enter Country");
        address.setCountry(scanner.next());
        System.out.println("please enter city");
        address.setCity(scanner.next());
        System.out.println("please enter street");
        address.setStreet(scanner.next());
        System.out.println("please enter building");
        address.setBuilding(scanner.next());
        System.out.println("please enter apartment");
        address.setApartment(scanner.next());
        contact.setAddress(address);

        return contact;
    }

    public static void SystemExit() {
        System.exit(0);
    }
}
