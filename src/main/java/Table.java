public class Table {

    private final int number;
    private final OrderList orderList;

    public Table(int number) {
        this.number = number;
        this.orderList = new OrderList();
    }

    public int getNumber() {
        return number;
    }

    public OrderList getOrderList() {
        return orderList;
    }
}
