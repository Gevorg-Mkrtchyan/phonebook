package phonebook.domain;

import java.io.Serializable;
import java.util.Objects;

public class Contact implements Comparable<Contact>, Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String emailType;
    private String phoneNumber;
    private String phoneNumberType;
    private Address address;

    public Contact() {

    }

    public Contact(String firstName, String lastName, String email, String emailType,
                   String phoneNumber, String phoneNumberType, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.emailType = emailType;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
        this.address = address;
    }

    public Contact(String firstName, String lastName, String phoneNumber, String phoneNumberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }

    public Contact(String firstName, String lastName, String email, String emailType, String phoneNumber,
                   String phoneNumberType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.emailType = emailType;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
    }

    public Contact(String firstName, String lastName, String phoneNumber, String phoneNumberType, Address address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
        this.address = address;
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

    @Override
    public int compareTo(Contact o) {
        return CharSequence.compare(firstName, o.firstName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(firstName, contact.firstName) &&
                Objects.equals(lastName, contact.lastName) && Objects.equals(email, contact.email) &&
                Objects.equals(emailType, contact.emailType) && Objects.equals(phoneNumber, contact.phoneNumber) &&
                Objects.equals(phoneNumberType, contact.phoneNumberType) && Objects.equals(address, contact.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email, emailType, phoneNumber, phoneNumberType, address);
    }

    @Override
    public String toString() {
        if (getEmail() == null && getAddress() == null) {
            return "Contact{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", phoneNumberType='" + phoneNumberType +
                    '}';
        } else if (getAddress() == null) {
            return "Contact{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", phoneNumberType='" + phoneNumberType + '\'' +
                    ", email='" + email + '\'' +
                    ", emailType='" + emailType + '\'' +
                    '}';
        } else if (getEmail() == null) {
            return "Contact{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", phoneNumberType='" + phoneNumberType + '\'' +
                    ", address=" + address +
                    '}';
        } else {
            return "Contact{" +
                    "firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", phoneNumberType='" + phoneNumberType + '\'' +
                    ", email='" + email + '\'' +
                    ", emailType='" + emailType + '\'' +
                    ", address=" + address +
                    '}';
        }
    }
}