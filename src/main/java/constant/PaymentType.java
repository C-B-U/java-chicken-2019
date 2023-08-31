package constant;

import java.util.Arrays;

public enum PaymentType {

    CARD(1, 1),
    CASH(2, 0.95);

    private final int number;
    private final double discountRate;

    PaymentType(int number, double discountRate) {
        this.number = number;
        this.discountRate = discountRate;
    }

    public static PaymentType getPaymentType(int number) {
        return Arrays.stream(PaymentType.values())
                .filter(paymentType -> paymentType.number == number)
                .findAny()
                .orElseThrow();
    }

    public double getDiscountRate() {
        return discountRate;
    }
}
