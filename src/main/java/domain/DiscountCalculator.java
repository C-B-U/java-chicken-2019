package domain;

import java.util.List;

public class DiscountCalculator {
    private static final String CHICKEN = "치킨";

    public static double calculateDiscountRate(PaymentMethod paymentMethod, List<Order> orders) {
        return calculateChickenDiscountRate(paymentMethod, orders);
    }

    private static double calculateChickenDiscountRate(PaymentMethod paymentMethod, List<Order> orders) {
        int chickenCount = 0;
        double finalAmount = 0.0;
        for(Order order : orders) {
            if (order.getMenuType().equals(CHICKEN)) {
                chickenCount += order.getMenuQuantity();
            }
            finalAmount += order.getPrice();
        }
        return calculateAdditionalDiscountRate(paymentMethod, finalAmount - (Math.floor((double) chickenCount / 10) * 10000));
    }


    private static double calculateAdditionalDiscountRate(PaymentMethod paymentMethod, Double finalAmount) {
        if (paymentMethod == PaymentMethod.CASH) {
            return finalAmount * paymentMethod.discountRate;
        }
        return finalAmount;
    }
}
