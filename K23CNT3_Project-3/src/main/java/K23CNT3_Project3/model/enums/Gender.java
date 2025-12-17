
package K23CNT3_Project3.model.enums;

public enum Gender {
    MALE("Nam"),
    FEMALE("Nữ"),
    UNISEX("Unisex");

    private final String displayName;

    Gender(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Gender fromString(String text) {
        for (Gender gender : Gender.values()) {
            if (gender.displayName.equalsIgnoreCase(text) ||
                    gender.name().equalsIgnoreCase(text)) {
                return gender;
            }
        }
        return UNISEX;
    }
}