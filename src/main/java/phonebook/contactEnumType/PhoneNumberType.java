package phonebook.contactEnumType;

import java.util.HashMap;
import java.util.Map;

public enum PhoneNumberType {
    Work(1, "Work"),
    Mobile(2, "Mobile"),
    Home(3, "Home"),
    School(4, "School");
    private static final Map<Integer, PhoneNumberType> phoneBookType = new HashMap<>();
    private final int code;
    private final String name;

    static {
        for (PhoneNumberType type : PhoneNumberType.values()) {
            phoneBookType.put(type.getCode(), type);
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
        return phoneBookType.get(id);
    }
}
