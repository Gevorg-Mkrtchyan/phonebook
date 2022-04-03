package phonebook.service.impl;

import phonebook.contactEnumType.EmailType;
import phonebook.contactEnumType.PhoneNumberType;
import phonebook.domain.Address;
import phonebook.domain.Contact;
import phonebook.service.ContactService;
import phonebook.validator.ContactValidator;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ContactServiceImpl implements ContactService {
    private final Scanner scanner = new Scanner(System.in);
    Contact contact = new Contact();


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
        Contact result = null;
        if (contacts != null && contact != null) {
            for (Contact cont : contacts) {
                if (cont.getFirstName().equals(contact.getFirstName()) && cont.getLastName().equals(contact.getLastName())
                        && cont.getPhoneNumber().equals(contact.getPhoneNumber())) {
                    result = cont;
                }
            }
        }
        return result;
    }

    @Override
    public boolean addContact(Set<Contact> contacts) {
        if (contacts != null) {
            contact = createContact();
            contacts.add(contact);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(Set<Contact> contacts) {
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
            System.out.println("please enter phone number for editing contact");
            String contNumber = scanner.next();
            for (Contact cont : contacts) {
                if (cont.getFirstName().equals(name) && cont.getPhoneNumber().equals(contNumber)) {
                    System.out.println("please enter new contact");
                    Contact newContacts = createContact();
                    Contact contactEdit = getContact(contact, contacts);
                    edited = updatedContactToContact(newContacts, contactEdit);
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
            System.out.println("print contact");
        }
        contacts.forEach(System.out::println);
    }

    public void deleteContactByPhoneNumber(Set<Contact> contacts) {
        if (contacts != null) {
            System.out.println("please enter phone for deleting contact");
            String contactNumber = scanner.next();
            if (contacts.removeIf(contact -> contact.getPhoneNumber().equals(contactNumber))) {
                System.out.println("Contact is deleted");
            } else {
                System.out.println("contact does not exist");
            }
        }

    }

    private static Contact updatedContactToContact(Contact source, Contact destination) {
        destination.setFirstName(source.getFirstName());
        destination.setLastName(source.getLastName());
        destination.setPhoneNumber(source.getPhoneNumber());
        destination.setPhoneNumberType(source.getPhoneNumberType());
        destination.setEmail(source.getEmail());
        destination.setEmailType(source.getEmailType());
        destination.setAddress(source.getAddress());
        return destination;
    }

    public static Contact createContact() {
        Scanner scanner = new Scanner(System.in);
        Contact contact = new Contact();
        String select = "+";
        System.out.println("please enter fist name, name must be range in 3 - 15 symbols");
        while (true) {
            contact.setFirstName(scanner.next());
            if (ContactValidator.isValidFirstName(contact.getFirstName())) {
                break;
            } else {
                System.out.println("no valid firstName try again");
            }
        }
        System.out.println("please enter last name, name must be range in 6 - 20 symbols");
        while (true) {
            contact.setLastName(scanner.next());
            if (ContactValidator.isValidLastName(contact.getLastName())) {
                break;
            } else {
                System.out.println("no valid lastName try again");
            }
        }
        System.out.println("please enter phone number must be range in 6 - 25 numbers ex (+374 ******)");
        while (true) {
            contact.setPhoneNumber(scanner.next());
            if (ContactValidator.isValidPhoneNumber(contact.getPhoneNumber())) {
                break;
            } else {
                System.out.println("no valid phone number");
            }
        }
        System.out.println("""
                please enter contact type in phone book\s
                (1 for Work, 2 for Mobile, 3 for Home, 4 for School)""");
        String phoneNumberType = scanner.next();
        switch (phoneNumberType) {
            case "1" -> contact.setPhoneNumberType(PhoneNumberType.Work.getName());
            case "2" -> contact.setPhoneNumberType(PhoneNumberType.Mobile.getName());
            case "3" -> contact.setPhoneNumberType(PhoneNumberType.Home.getName());
            case "4" -> contact.setPhoneNumberType(PhoneNumberType.School.getName());
            default -> System.out.println("other phone type");
        }
        System.out.println("""
                Do you want to add an email?\s
                 if yes = '+'  if no = other""");
        String selectEmail = scanner.next();
        if (selectEmail.equals(select)) {
            System.out.println("please enter email, email range >= 6  ex qwerty@gmail.com");
            while (true) {
                contact.setEmail(scanner.next());
                if (ContactValidator.isValidEmail(contact.getEmail())) {
                    break;
                } else {
                    System.out.println("no valid email try again");
                }
            }
            System.out.println("""
                    please enter contact type in email\s
                    (1 for gmail,2 for mail,3 for yahoo, 4 for yandex)""");
            String emailType = scanner.next();
            switch (emailType) {
                case "1" -> contact.setEmailType(EmailType.GMAIL.getName());
                case "2" -> contact.setEmailType(EmailType.MAIL.getName());
                case "3" -> contact.setEmailType(EmailType.YAHOO.getName());
                case "4" -> contact.setEmailType(EmailType.YANDEX.getName());
                default -> System.out.println("other email type");
            }
        }
        System.out.println("Do you want to add an address? \n if yes = '+'  if no = other");
        String addAddress = scanner.next();
        if (addAddress.equals(select)) {
            Address address = new Address();
            System.out.println("please enter Country, range is 3 to 20");
            while (true) {
                address.setCountry(scanner.next());
                if (ContactValidator.isValidCountry(address.getCountry())) {
                    break;
                } else {
                    System.out.println("no valid country name try again");
                }
            }
            System.out.println("please enter city range is 3 to 20");
            while (true) {
                address.setCity(scanner.next());
                if (ContactValidator.isValidCity(address.getCity())) {
                    break;
                } else {
                    System.out.println("no valid city name try again");
                }
            }
            System.out.println("please enter street range is 4 to 23");
            while (true) {
                address.setStreet(scanner.next());
                if (ContactValidator.isValidStreet(address.getStreet())) {
                    break;
                } else {
                    System.out.println("no valid street name try again");
                }
            }
            System.out.println("please enter building range is 1 to 999 numbers");
            while (true) {
                address.setBuilding(scanner.next());
                if (ContactValidator.isValidBuilding(address.getBuilding())) {
                    break;
                } else {
                    System.out.println("no valid building try again");
                }
            }
            System.out.println("please enter apartment range is 1 to 999 numbers");
            while (true) {
                address.setApartment(scanner.next());
                if (ContactValidator.isValidApartment(address.getApartment())) {
                    break;
                } else {
                    System.out.println("no valid apartment try again");
                }

            }
            contact.setAddress(address);
        }
        return contact;
    }

    public static void SystemExit() {
        System.out.println("phone book is closed");
        System.out.println("Thank you for using our phonebook ☺");
        System.exit(0);
    }
}
