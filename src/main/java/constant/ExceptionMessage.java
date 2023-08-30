package constant;

public enum ExceptionMessage {

    INCORRECT_MAIN_OPTION("존재하지 않는 기능입니다."),
    NOT_EXIST_MENU("존재하지 않는 메뉴입니다."),
    NOT_EXIST_TABLE("존재하지 않는 테이블입니다.");

    private static final String PREFIX = "[ERROR] ";
    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return PREFIX + message;
    }
}
