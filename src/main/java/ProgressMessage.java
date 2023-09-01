public enum ProgressMessage {
    MAIN_MESSAGE("## 메인화면"),
    SELECT_NUMBER("## 원하는 기능을 선택하세요."),
    TABLE_LIST("## 테이블 목록"),
    SELECT_TABLE("## 테이블을 선택하세요.");

    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
