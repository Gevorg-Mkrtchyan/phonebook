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

    public static boolean isValidEmail(String email) {
        if (email == null) {
            return false;
        }
        int len = email.length();
        return len >= 6;
    }

    public static boolean isValidCountry(String country) {
        if (country == null || country.length() == 0) {
            return false;
        }
        int len = country.length();
        for (int i = 0; i < len; i++) {
            if (country.charAt(i) < 65 || country.charAt(i) > 122) {
                return false;
            }
        }
        return len >= 3 && len <= 20;
    }

    public static boolean isValidCity(String city) {
        if (city == null || city.length() == 0) {
            return false;
        }
        int len = city.length();
        for (int i = 0; i < len; i++) {
            if (city.charAt(i) < 65 || city.charAt(i) > 122) {
                return false;
            }
        }
        return len >= 3 && len <= 20;
    }

    public static boolean isValidStreet(String street) {
        if (street == null) {
            return false;
        }
        int len = street.length();
        return len >= 6 && len <= 23;
    }

    public static boolean isValidBuilding(String building) {
        if (building == null) {
            return false;
        }
        int len = building.length();
        for (int i = 0; i < len; i++) {
            if (building.charAt(i) < '1' || building.charAt(i) > '9') {
                return false;
            }
        }
        return len >= 1 && len <= 3;
    }

    public static boolean isValidApartment(String apartment) {
        if (apartment == null) {
            return false;
        }
        int len = apartment.length();
        for (int i = 0; i < len; i++) {
            if (apartment.charAt(i) < '1' || apartment.charAt(i) > '9') {
                return false;
            }
        }
        return len >= 1 && len <= 3;
    }
}




