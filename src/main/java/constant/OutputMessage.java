package constant;

public enum OutputMessage {

    MAIN_OPTION("메인화면");

    private static final String PREFIX = "## ";
    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + this.message;
    }
}
