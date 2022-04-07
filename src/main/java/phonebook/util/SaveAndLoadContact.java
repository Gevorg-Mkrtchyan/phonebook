package phonebook.util;

import phonebook.domain.Address;
import phonebook.domain.Contact;

import java.io.*;
import java.util.Set;

public class SaveAndLoadContact {
    private static final String file = "src/main/resources/file.txt";

    public static void write(Set<Contact> contacts) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (Contact c : contacts) {
                if (c.getEmail() != null && c.getAddress() == null) {
                    writer.write(c.getFirstName() + "†" + c.getLastName() + "†" + c.getPhoneNumber() + "†"
                            + c.getPhoneNumberType() + "†" + c.getEmail() + "†" + c.getEmailType() + "\n");
                } else if (c.getAddress() == null && c.getEmail() == null) {
                    writer.write(c.getFirstName() + "†" + c.getLastName() +
                            "†" + c.getPhoneNumber() + "†" + c.getPhoneNumberType() + "\n");
                } else if (c.getAddress() != null && c.getEmail() == null) {
                    writer.write(c.getFirstName() + "†" + c.getLastName() +
                            "†" + c.getPhoneNumber() + "†" + c.getPhoneNumberType() + "†"
                            + c.getAddress().getCountry() + "†" + c.getAddress().getCity() +
                            "†" + c.getAddress().getStreet() + "†" + c.getAddress().getBuilding()
                            + "†" + c.getAddress().getApartment() + "\n");
                } else {
                    writer.write(c.getFirstName() + "†" + c.getLastName() + "†" + c.getPhoneNumber() + "†"
                            + c.getPhoneNumberType() + "†" + c.getEmail() + "†" + c.getEmailType() + "†" +
                            c.getAddress().getCountry() + "†" + c.getAddress().getCity() + "†" +
                            c.getAddress().getStreet() + "†" + c.getAddress().getBuilding() + "†" +
                            c.getAddress().getApartment() + "\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(Set<Contact> contacts) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            String[] words;
            while ((line = reader.readLine()) != null) {
                words = line.split("†");
                if (words.length == 11) {
                    contacts.add(new Contact(words[0], words[1], words[9], words[10], words[2], words[3],
                            new Address(words[4], words[5], words[6], words[7], words[8])));
                } else if (words.length == 9) {
                    contacts.add(new Contact(words[0], words[1], words[2], words[3],
                            new Address(words[4], words[5], words[6], words[7], words[8])));
                } else if (words.length == 6) {
                    contacts.add(new Contact(words[0], words[1], words[4], words[5], words[2], words[3]));
                } else {
                    contacts.add(new Contact(words[0], words[1], words[2], words[3]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

