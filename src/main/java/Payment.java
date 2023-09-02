import java.util.Map;
import java.util.Set;

public class Payment {

    private static final String DISCOUNT_MENU = "치킨";
    private static final String CURRENCY_UNIT = "원";
    public final OrderList orderList;
    public int chickenQuantitySum = 0;
    public double paymentPrice;

    public Payment(OrderList orderList) {
        this.orderList = orderList;
        this.paymentPrice = initPaymentPrice();
    }

    private int initPaymentPrice(){
        int price, quantity, sum = 0;
        for (Map.Entry<Menu, Integer> entry : orderList.getMenus().entrySet()) {
            price = entry.getKey().getPrice();
            quantity = entry.getValue();
            sum += price * quantity;
        }
        return sum;
    }

    public void applyDiscount(int paymentNumber){
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
        if (chickenQuantitySum > 10.0){
            double discount = (chickenQuantitySum / 10.0) * 10000;
            paymentPrice -= discount;
        }
    }

    private void cashDisCount(int paymentNumber) {
        if (paymentNumber == 2){
            paymentPrice -= paymentPrice * 0.05;
        }
    }

    @Override
    public String toString() {
        return (int)paymentPrice + CURRENCY_UNIT;
    }
}
