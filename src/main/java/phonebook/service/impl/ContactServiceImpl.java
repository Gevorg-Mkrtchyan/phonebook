package phonebook.service.impl;

import phonebook.contactEnumType.EmailType;
import phonebook.contactEnumType.PhoneNumberType;
import phonebook.domain.Address;
import phonebook.domain.Contact;
import phonebook.service.ContactService;
import phonebook.validator.ContactValidator;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContactServiceImpl implements ContactService {
    private final Scanner scanner = new Scanner(System.in);
    Contact contact = new Contact();

    @Override
    public Set<Contact> getByNameAndLastName(Set<Contact> contacts) {
        Set<Contact> result = new TreeSet<>();
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
        Set<Contact> result = new TreeSet<>();
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
        Contact result = null;
        if (contacts != null && contact != null) {
            for (Contact cont : contacts) {
                if (cont.getFirstName().equals(contact.getFirstName()) && cont.getLastName().equals
                        (contact.getLastName()) && cont.getPhoneNumber().equals(contact.getPhoneNumber())) {
                    result = cont;
                }
            }
        }
        return result;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        Contact contact = new Contact();
        createContact(contact);
        if (contacts != null) {
            for (Contact cont : contacts) {
                if (cont.getFirstName().equals(contact.getFirstName()) &&
                        cont.getLastName().equals(contact.getLastName())) {
                    System.out.println("this contact is already exist");
                    return false;
                }
            }
            System.out.println("if you save contact print + else print - symbol");
            while (true) {
                String select = scanner.next();
                if (select.equals("+")) {
                    contacts.add(contact);
                    System.out.println("You successfully add contact");
                    break;
                } else if (select.equals("-")) {
                    System.out.println("contact don't save");
                    break;
                } else {
                    System.out.println("if you save contact print + else print - symbol");
                }
            }
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteContactByFirstAndLastNames(Set<Contact> contacts) {
        if (contacts != null) {
            System.out.println("Please enter firstName");
            String firstName = scanner.next();
            System.out.println("Please enter lastName");
            String lastName = scanner.next();
            return contacts.removeIf(contact -> contact.getFirstName().equals(firstName)
                    && contact.getLastName().equals(lastName));
        }
        return false;
    }

    @Override
    public Contact editeContact(Set<Contact> contacts) {
        Contact edited = null;
        if (contacts != null) {
            System.out.println("please enter first name");
            String name = scanner.next();
            System.out.println("please enter phone number for edit the contact");
            String contNumber = scanner.next();
            for (Contact cont : contacts) {
                if (cont.getFirstName().equals(name) && cont.getPhoneNumber().equals(contNumber)) {
                    System.out.println("please enter new edited contact");
                    edited = createContact(cont);
                }
            }
        }
        return edited;
    }

    @Override
    public void getAllContacts(Set<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("contacts is empty");
        } else {
            System.out.println("printed your contacts");
        }
        contacts.forEach(System.out::println);
    }

    public void deleteAll(Set<Contact> contacts) {
        contacts.clear();
        System.out.println("Contact is deleted");
    }

    public void deleteContactByNameAndNumber(Set<Contact> contacts) {
        if (contacts != null) {
            System.out.println("please enter first name");
            String firstName = scanner.next();
            System.out.println("please enter phone number to delete the contact");
            String contactNumber = scanner.next();
            if (contacts.removeIf(contact -> contact.getPhoneNumber().equals(contactNumber)
                    && contact.getFirstName().equals(firstName))) {
                System.out.println("Contact is deleted");
            } else {
                System.out.println("contact does not exist");
            }
        }
    }

    public static Contact createContact(Contact contact) {
        Scanner scanner = new Scanner(System.in);
        String select = "+";
        System.out.println("please enter fist name, name must be in range 3 - 15 symbols");
        while (true) {
            contact.setFirstName(scanner.next());
            if (ContactValidator.isValidFirstName(contact.getFirstName())) {
                break;
            } else {
                System.err.println("invalid firstName try again");
            }
        }
        System.out.println("please enter last name, name must be in range 6 - 20 symbols");
        while (true) {
            contact.setLastName(scanner.next());
            if (ContactValidator.isValidLastName(contact.getLastName())) {
                break;
            } else {
                System.err.println("invalid lastName try again");
            }
        }
        System.out.println("please enter phone number must be in range 6 - 25 numbers ex (+374 ******)");
        while (true) {
            contact.setPhoneNumber(scanner.next());
            if (ContactValidator.isValidPhoneNumber(contact.getPhoneNumber())) {
                break;
            } else {
                System.err.println("invalid phone number");
            }
        }
        System.out.println("""
                please enter contact type in phone book\s
                (1 for Work, 2 for Mobile, 3 for Home, 4 for School, 5 for other)""");
        while (true) {
            String phoneNumberType = scanner.next();
            if (phoneNumberType.equals("1") || phoneNumberType.equals("2") || phoneNumberType.equals("3")
                    || phoneNumberType.equals("4") || phoneNumberType.equals("5")) {
                switch (phoneNumberType) {
                    case "1" -> contact.setPhoneNumberType(PhoneNumberType.Work.getName());
                    case "2" -> contact.setPhoneNumberType(PhoneNumberType.Mobile.getName());
                    case "3" -> contact.setPhoneNumberType(PhoneNumberType.Home.getName());
                    case "4" -> contact.setPhoneNumberType(PhoneNumberType.School.getName());
                    case "5" -> contact.setPhoneNumberType(PhoneNumberType.OTHER.getName());
                }
                break;
            } else {
                System.out.println("try again");
            }
        }
        System.out.println("""
                Do you want to add an email?\s
                if yes print '+' else print other symbol""");
        String selectEmail = scanner.next();
        if (selectEmail.equals(select)) {
            System.out.println("please enter email, email range >= 6  ex qwerty@gmail.com");
            while (true) {
                contact.setEmail(scanner.next());
                if (ContactValidator.isValidEmail(contact.getEmail())) {
                    break;
                } else {
                    System.err.println("invalid email try again");
                }
            }
            System.out.println("""
                    please enter contact type in email\s
                    (1 for gmail,2 for mail,3 for yahoo, 4 for yandex, 5 for other)""");
            while (true) {
                String emailType = scanner.next();
                if (emailType.equals("1") || emailType.equals("2") || emailType.equals("3")
                        || emailType.equals("4") || emailType.equals("5")) {
                    switch (emailType) {
                        case "1" -> contact.setEmailType(EmailType.GMAIL.getName());
                        case "2" -> contact.setEmailType(EmailType.MAIL.getName());
                        case "3" -> contact.setEmailType(EmailType.YAHOO.getName());
                        case "4" -> contact.setEmailType(EmailType.YANDEX.getName());
                        case "5" -> contact.setEmailType(EmailType.OTHER.getName());
                    }
                    break;
                } else {
                    System.out.println("try again");
                }
            }
        }
        System.out.println("""
                Do you want to add an address?\s
                if yes print '+' else print other symbol""");
        String addAddress = scanner.next();
        if (addAddress.equals(select)) {
            Address address = new Address();
            System.out.println("please enter Country name in range from 3 to 20");
            while (true) {
                address.setCountry(scanner.next());
                if (ContactValidator.isValidCountry(address.getCountry())) {
                    break;
                } else {
                    System.err.println("invalid country name try again");
                }
            }
            System.out.println("please enter city name in range from 3 to 20");
            while (true) {
                address.setCity(scanner.next());
                if (ContactValidator.isValidCity(address.getCity())) {
                    break;
                } else {
                    System.err.println("invalid city name try again");
                }
            }
            System.out.println("please enter street in range from 4 to 23");
            while (true) {
                address.setStreet(scanner.next());
                if (ContactValidator.isValidStreet(address.getStreet())) {
                    break;
                } else {
                    System.err.println("invalid street name try again");
                }
            }
            System.out.println("please enter building number in range from 1 to 999 numbers");
            while (true) {
                address.setBuilding(scanner.next());
                if (ContactValidator.isValidBuilding(address.getBuilding())) {
                    break;
                } else {
                    System.err.println("invalid building try again");
                }
            }
            System.out.println("please enter apartment in range from 1 to 999 numbers");
            while (true) {
                address.setApartment(scanner.next());
                if (ContactValidator.isValidApartment(address.getApartment())) {
                    break;
                } else {
                    System.err.println("invalid apartment try again");
                }
            }
            contact.setAddress(address);
        }
        return contact;
    }

    public static void SystemExit() {
        System.out.println("\u001B[36m" + "phone book is closed");
        System.out.println("Thank you for using our phonebook ☺");
        System.out.println("Phone Book version 1.2");
        System.exit(0);
    }
}
