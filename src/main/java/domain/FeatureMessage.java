package domain;

public enum FeatureMessage {
    REGISTER_ORDER("1 - 주문등록\n"),
    PAYMENT("2 - 결제하기\n"),
    QUIT_PROGRAM("3 - 프로그램 종료\n");

    private final String message;

    FeatureMessage(String message) {
        this.message = message;
    }

    public static String getMessage() {
        return REGISTER_ORDER.message + PAYMENT.message + QUIT_PROGRAM.message;
    }
}
