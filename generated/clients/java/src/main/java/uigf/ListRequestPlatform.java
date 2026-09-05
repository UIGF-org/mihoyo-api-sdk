package uigf;

/**
 * Defines values for ListRequestPlatform.
 */
public enum ListRequestPlatform {
    /**
     * Enum value pc.
     */
    PC("pc"),

    /**
     * Enum value android.
     */
    ANDROID("android"),

    /**
     * Enum value ios.
     */
    IOS("ios");

    /**
     * The actual serialized value for a ListRequestPlatform instance.
     */
    private final String value;

    ListRequestPlatform(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a ListRequestPlatform instance.
     * 
     * @param value the serialized value to parse.
     * @return the parsed ListRequestPlatform object, or null if unable to parse.
     */
    public static ListRequestPlatform fromString(String value) {
        if (value == null) {
            return null;
        }
        ListRequestPlatform[] items = ListRequestPlatform.values();
        for (ListRequestPlatform item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.value;
    }
}
