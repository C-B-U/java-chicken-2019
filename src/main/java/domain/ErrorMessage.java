package domain;

public enum ErrorMessage {
    WRONG_FEATURE_NUMBER("잘못된 기능 번호입니다. 다시 입력해 주세요."),
    WRONG_TABLE_NUMBER("잘못된 테이블 번호입니다. 다시 입력해 주세요."),
    WRONG_MENU_NUMBER("잘못된 메뉴 번호입니다. 다시 입력해 주세요."),
    WRONG_QUANTITY("잘못된 메뉴 수량입니다. 99 이하로 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
