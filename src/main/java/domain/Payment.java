package domain;

import java.util.Arrays;

public enum Payment {
    CREDIT_CARD(1, "신용카드"),
    CASH(2, "현금");

    final int paymentNumber;
    final String paymentType;

    Payment(int paymentNumber, String paymentType) {
        this.paymentNumber = paymentNumber;
        this.paymentType = paymentType;
    }

    public static Payment convert(String number) {
        return Arrays.stream(values())
                .filter(payment -> payment.paymentNumber == Integer.parseInt(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.WRONG_PAYMENT_NUMBER.toString()));
    }
}
