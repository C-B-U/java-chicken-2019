package constant;

public enum PrintElement {

    HYPHEN(" - "),
    NEW_LINE("\n"),
    HISTORY_CONFIG("메뉴 수량 금액"),
    BLANK(" ");

    private final String message;

    PrintElement(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
