package domain;

public enum ProcessMessage {
    MAIN_SCREEN("메인 화면"),
    SELECT_FEATURE("원하는 기능을 선택하세요."),
    TABLE_LIST("테이블 목록"),
    SELECT_TABLE("테이블을 선택하세요."),
    SELECT_MENU("등록할 메뉴를 선택하세요."),
    ENTER_QUANTITY("메뉴의 수량을 입력하세요.");

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
