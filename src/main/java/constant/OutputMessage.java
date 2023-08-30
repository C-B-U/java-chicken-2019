package constant;

public enum OutputMessage {

    MAIN_OPTION("메인화면"),
    OPTION_SELECT("원하는 기능을 선택하세요."),
    TABLE_SELECT("테이블을 선택하세요.");

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
