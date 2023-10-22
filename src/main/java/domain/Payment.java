package domain;

import constants.Menu;
import constants.PaymentMethod;

import java.util.Map;
import java.util.Set;

public class Payment {

    private static final String DISCOUNT_MENU = "치킨";
    private static final String CURRENCY_UNIT = "원";
    private static final int INIT_VALUE = 0;
    private static final double DISCOUNT_CHICKEN_AMOUNT = 10.0;
    private static final int TEN_THOUSAND = 10000;
    private static final double DISCOUNT_RATE = 0.05;
    private final OrderList orderList;
    private int chickenQuantitySum = 0;
    private double paymentPrice;

    public Payment(OrderList orderList) {
        this.orderList = orderList;
        this.paymentPrice = initPaymentPrice();
    }

    private int initPaymentPrice() {
        int price, quantity, sum = INIT_VALUE;
        for (Map.Entry<Menu, Integer> entry : orderList.getMenus().entrySet()) {
            price = entry.getKey().getPrice();
            quantity = entry.getValue();
            sum += price * quantity;
        }
        return sum;
    }

    public void applyDiscount(int paymentNumber) {
        countChickenQuantity();
        defaultDisCount();
        cashDisCount(paymentNumber);
        orderList.completePayment();
    }

    private void countChickenQuantity() {
        Set<Menu> menus = orderList.getMenus().keySet();
        for (Menu menu : menus) {
            if (menu.getType().equals(DISCOUNT_MENU)) {
                chickenQuantitySum++;
            }
        }
    }

    private void defaultDisCount() {
        if (chickenQuantitySum > DISCOUNT_CHICKEN_AMOUNT) {
            double discount = (chickenQuantitySum / DISCOUNT_CHICKEN_AMOUNT) * TEN_THOUSAND;
            paymentPrice -= discount;
        }
    }

    private void cashDisCount(int paymentNumber) {
        if (PaymentMethod.isCashType(paymentNumber)) {
            paymentPrice -= paymentPrice * DISCOUNT_RATE;
        }
    }

    @Override
    public String toString() {
        return (int) paymentPrice + CURRENCY_UNIT;
    }
}
