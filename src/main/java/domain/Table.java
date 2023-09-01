package domain;

public class Table {

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

    public int totalPrice() {
        return order.totalPrice();
    }

    public boolean hasOrder() {
        return order.hasOrder();
    }

    public int discountChicken() {
        return order.discountChicken();
    }

    public String getOrderHistory() {
        return order.toString();
    }

    public void payment() {
        order.payment();
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
