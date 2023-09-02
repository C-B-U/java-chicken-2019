package domain;

public enum ProcessMessage {
    MAIN_SCREEN("메인 화면");

    private static final String PREFIX = "## ";
    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
