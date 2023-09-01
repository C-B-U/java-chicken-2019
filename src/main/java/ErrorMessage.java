public enum ErrorMessage {
    INPUT_MAIN_NUMBER_ERROR("기능 번호는 %s 부터 %s 입니다."),
    INPUT_TABLE_NUMBER_ERROR("옳지 않는 테이블 번호입니다.");

    private static final String ERROR = "[ERROR]";
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return ERROR + message;
    }
}
