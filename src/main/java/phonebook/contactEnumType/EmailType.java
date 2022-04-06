package phonebook.contactEnumType;

import java.util.HashMap;
import java.util.Map;

public enum EmailType {
    GMAIL(1, "@gmail.com"),
    MAIL(2, "@mail.ru"),
    YAHOO(3, "@yahoo.com"),
    YANDEX(4, "@yandex.ru"),
    OTHER(5, "Other");
    private static final Map<Integer, EmailType> emailType = new HashMap<>();
    private final int code;
    private final String name;

    static {
        for (EmailType type : EmailType.values()) {
            emailType.put(type.getCode(), type);
        }
    }

    EmailType(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public static EmailType getId(int id) {
        return emailType.get(id);
    }
}
