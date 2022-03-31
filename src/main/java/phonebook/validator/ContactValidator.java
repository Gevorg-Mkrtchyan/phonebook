package phonebook.validator;

public final class ContactValidator {
    private ContactValidator() {

    }

    public static boolean isValidFirstName(String firstName) {
        if (firstName == null || firstName.length() == 0) {
            return false;
        }
        int len = firstName.length();
        for (int i = 0; i < len; i++) {
            if (firstName.charAt(i) < 65 || firstName.charAt(i) > 122) {
                return false;
            }
        }
        return len >= 3 && len <= 15;
    }

    public static boolean isValidLastName(String lastName) {
        if (lastName == null || lastName.length() == 0) {
            return false;
        }
        int len = lastName.length();
        for (int i = 0; i < len; i++) {
            if (lastName.charAt(i) < 65 || lastName.charAt(i) > 122) {
                return false;
            }
        }
        return len >= 6 && len <= 20;
    }

    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            return false;
        }
        int len = phoneNumber.length();
        for (int i = 0; i < len; i++) {
            if (phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9') {
                return false;
            }
        }
        return len >= 6 && len <= 25;
    }
}

