package uigf.community;

/**
 * Defines values for ListRequestAction.
 */
public enum ListRequestAction {
    /**
     * Enum value 1.
     */
    ONE("1"),

    /**
     * Enum value 2.
     */
    TWO("2");

    /**
     * The actual serialized value for a ListRequestAction instance.
     */
    private final String value;

    ListRequestAction(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a ListRequestAction instance.
     * 
     * @param value the serialized value to parse.
     * @return the parsed ListRequestAction object, or null if unable to parse.
     */
    public static ListRequestAction fromString(String value) {
        if (value == null) {
            return null;
        }
        ListRequestAction[] items = ListRequestAction.values();
        for (ListRequestAction item : items) {
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
