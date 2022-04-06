package phonebook.contactEnumType;

import java.util.HashMap;
import java.util.Map;

public enum PhoneNumberType {
    Work(1, "Work"),
    Mobile(2, "Mobile"),
    Home(3, "Home"),
    School(4, "School"),
    OTHER(5, "Other");
    private static final Map<Integer, PhoneNumberType> phoneNumber = new HashMap<>();
    private final int code;
    private final String name;

    static {
        for (PhoneNumberType type : PhoneNumberType.values()) {
            phoneNumber.put(type.getCode(), type);
        }
    }

    PhoneNumberType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static PhoneNumberType getId(int id) {
        return phoneNumber.get(id);
    }
}
