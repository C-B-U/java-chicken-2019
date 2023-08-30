package constant;

public enum PrintElement {

    HYPHEN(" - "),
    NEW_LINE("\n");

    private final String message;

    PrintElement(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
