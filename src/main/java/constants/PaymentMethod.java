package constants;

public enum PaymentMethod {
    CREDIT_CARD(1, "신용 카드"),
    CASH(2, "현금");

    private static final int LAST_CHAR = 1;
    private final int number;
    private final String method;

    PaymentMethod(int number, String method) {
        this.number = number;
        this.method = method;
    }

    public static void validatePaymentNumber(int number) {
        if (number < CREDIT_CARD.number || number > CASH.number) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INPUT_PAYMENT_NUMBER_ERROR.toString()
                    , CREDIT_CARD.number, CASH.number));
        }
    }

    public static String showPaymentMethod() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("##");
        for (PaymentMethod paymentMethod : PaymentMethod.values()) {
            stringBuilder.append(String.format(" %s는 %s번,", paymentMethod.method, paymentMethod.number));
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - LAST_CHAR);
        return stringBuilder.toString();
    }

    public static boolean isCashType(int number) {
        return number == CASH.number;
    }
}
