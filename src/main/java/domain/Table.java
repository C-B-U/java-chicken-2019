package domain;

import constant.PaymentType;

public class Table {

    private static final int DISCOUNT_PRICE = 10000;

    private final int number;
    private final Order order;

    public Table(final int number) {
        this.number = number;
        this.order = new Order();
    }

    public boolean isExist(int number) {
        return number == this.number;
    }

    public void addMenu(Menu menu, int quantity) {
        order.addMenu(menu, quantity);
    }

    public boolean hasOrder() {
        return order.hasOrder();
    }


    public int payment(PaymentType type) {
        int totalPrice = calculateTotalPrice(type);
        order.payment();
        return totalPrice;
    }

    public int calculateTotalPrice(PaymentType type) {
        return (int) ((totalPrice() - chickenDiscount()) * type.getDiscountRate());
    }

    private int totalPrice() {
        return order.totalPrice();
    }

    private int chickenDiscount() {
        return discountChicken() / 10 * DISCOUNT_PRICE;
    }

    public int discountChicken() {
        return order.chickenNumber();
    }

    public String getOrderHistory() {
        return order.toString();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
