package domain;

import java.util.Arrays;

public enum PaymentMethod {
    CREDIT_CARD(1, "신용카드", 100.0),
    CASH(2, "현금", 0.95);

    final int paymentNumber;
    final String paymentType;
    final Double discountRate;

    PaymentMethod(int paymentNumber, String paymentType, Double discountRate) {
        this.paymentNumber = paymentNumber;
        this.paymentType = paymentType;
        this.discountRate = discountRate;
    }

    public static PaymentMethod convert(String number) {
        return Arrays.stream(values())
                .filter(paymentMethod -> paymentMethod.paymentNumber == Integer.parseInt(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.WRONG_PAYMENT_NUMBER.toString()));
    }
}
