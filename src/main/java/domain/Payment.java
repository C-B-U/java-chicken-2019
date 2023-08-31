package domain;

import constant.PaymentType;
import constant.PrintElement;

public class Payment {

    private static final int DISCOUNT_PRICE = 10000;

    private final int price;

    public Payment(Table table, PaymentType type) {
        this.price = calculateTotalPrice(table, type);
    }

    public int calculateTotalPrice(Table table, PaymentType type) {
        return (int) ((table.totalPrice() - chickenDiscount(table)) * paymentDiscount(type));
    }

    private int chickenDiscount(Table table) {
        return table.discountChicken() / 10 * DISCOUNT_PRICE;
    }

    private double paymentDiscount(PaymentType type) {
        return type.getDiscountRate();
    }

    @Override
    public String toString() {
        return String.format(PrintElement.TOTAL_PRICE.toString(), price);
    }
}
