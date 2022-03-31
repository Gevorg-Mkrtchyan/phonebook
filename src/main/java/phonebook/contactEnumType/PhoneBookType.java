package phonebook.contactEnumType;

import java.util.HashMap;
import java.util.Map;

public enum PhoneBookType {
    Work(1, "Work "),
    Mobile(2, "Mobile"),
    Home(3, "Home"),
    School(4, "School");
    private static final Map<Integer, PhoneBookType> phoneBookType = new HashMap<>();
    private final int code;
    private final String name;

    static {
        for (PhoneBookType type : PhoneBookType.values()) {
            phoneBookType.put(type.getCode(), type);
        }
    }

    PhoneBookType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static PhoneBookType getId(int id) {
        return phoneBookType.get(id);
    }
}
