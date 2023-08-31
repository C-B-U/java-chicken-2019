package constant;

public enum OutputMessage {

    MAIN_OPTION("메인화면"),
    OPTION_SELECT("원하는 기능을 선택하세요."),
    TABLE_SELECT("테이블을 선택하세요."),
    MENU("등록할 메뉴를 선택하세요."),
    QUANTITY("메뉴의 수량을 입력하세요."),
    ORDER_HISTORY("주문 내역"),
    PAYMENT_START("%s번 테이블의 결제를 진행합니다"),
    PAYMENT_METHOD("신용 카드는 1번, 현금은 2번"),
    TOTAL_PRICE("최종 결제할 금액");

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
