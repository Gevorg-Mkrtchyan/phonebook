package phonebook.domain;

import java.util.Comparator;
import java.util.Objects;

public class Contact implements Comparator<Contact> {
    private final int id;
    private String firstName;
    private String lastName;
    private String email;
    private String emailType;
    private String phoneNumber;
    private String phoneNumberType;
    private Address address;
    private static int count;

    public Contact() {
        this.id = count++;
    }

    public Contact(int id, String firstName, String lastName, String email, String phoneNumber, String phoneNumberType) {
        this.id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }

    public Contact(int id, String firstName, String lastName, String email, String emailType,
                   String phoneNumber, String phoneNumberType, Address address) {
        this.id = count++;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.emailType = emailType;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailType() {
        return emailType;
    }

    public void setEmailType(String emailType) {
        this.emailType = emailType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(String phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        Contact.count = count;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", phoneNumberType='" + phoneNumberType + '\'' +
                ", email='" + email + '\'' +
                ", emailType='" + emailType + '\'' +
                ", address=" + address +
                '}';
    }

    @Override
    public int compare(Contact o1, Contact o2) {
        return o1.firstName.compareTo(o2.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return id == contact.id && Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName) && Objects.equals(email, contact.email) &&
                Objects.equals(emailType, contact.emailType) && Objects.equals(phoneNumber, contact.phoneNumber) &&
                Objects.equals(phoneNumberType, contact.phoneNumberType) && Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, email, emailType, phoneNumber, phoneNumberType, address);
    }
}
