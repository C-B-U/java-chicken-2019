public enum ErrorMessage {
    INPUT_MAIN_NUMBER_ERROR("기능 번호는 %s 부터 %s 입니다."),
    INPUT_TABLE_NUMBER_ERROR("옳지 않는 테이블 번호입니다."),
    INPUT_MENU_NUMBER_ERROR("옳지 않는 메뉴 번호입니다."),
    INPUT_MENU_QUANTITY_ERROR("한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 %s 개입니다."),
    INPUT_PAYMENT_NUMBER_ERROR("신용 카드는 %s번, 현금은 %s번 입니다.");

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
