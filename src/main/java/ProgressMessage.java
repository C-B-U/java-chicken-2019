public enum ProgressMessage {
    MAIN_MESSAGE("## 메인화면"),
    SELECT_NUMBER("## 원하는 기능을 선택하세요."),
    TABLE_LIST("## 테이블 목록"),
    SELECT_TABLE("## 테이블을 선택하세요."),
    SELECT_MENU("## 등록할 메뉴를 선택하세요."),
    INPUT_MENU_QUANTITY("## 메뉴의 수량을 입력하세요."),
    ORDER_HISTORY("## 주문 내역"),
    HISTORY_ELEMENT("메뉴 수량 금액"),
    PAYMENT_PROGRESS("## %s번 테이블의 결제를 진행합니다."),
    PAYMENT_AMOUNT("## 최종 결제할 금액");

    private final String message;

    ProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
