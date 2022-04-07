package phonebook.service;

import phonebook.domain.Contact;

import java.util.Set;

public interface ContactService {
    Set<Contact> getByNameAndLastName(Set<Contact> contacts);

    Set<Contact> getByPhoneNumber(Set<Contact> contacts);

    Contact getContact(Contact contact, Set<Contact> contacts);

    boolean addContact(Set<Contact> contacts);

    boolean deleteContactByFirstAndLastNames(Set<Contact> contacts);

    Contact editeContact(Set<Contact> contacts);

    void getAllContacts(Set<Contact> contacts);

    void deleteContactByNameAndNumber(Set<Contact> contacts);
}
