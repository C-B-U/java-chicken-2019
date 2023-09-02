package domain;

public enum ErrorMessage {
    WRONG_FEATURE_NUMBER("잘못된 기능 번호입니다. 다시 입력해 주세요.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
