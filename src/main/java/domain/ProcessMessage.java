package domain;

public enum ProcessMessage {
    MAIN_SCREEN("메인 화면"),
    SELECT_FEATURE("원하는 기능을 선택하세요."),
    TABLE_LIST("테이블 목록"),
    SELECT_TABLE("테이블을 선택하세요."),
    SELECT_MENU("등록할 메뉴를 선택하세요."),
    ENTER_QUANTITY("메뉴의 수량을 입력하세요."),
    ORDER_DETAILS("주문 내역"),
    PROCEED_PAYMENT("%d번 테이블의 결제를 진행합니다."),
    SELECT_PAYMENT_METHOD("신용 카드는 1번, 현금은 2번"),
    FINAL_PAYMENT_AMOUNT("최종 결제할 금액");

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
