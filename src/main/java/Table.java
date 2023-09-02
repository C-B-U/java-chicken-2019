public class Table {

    private final int number;
    private boolean isOrdering;
    private final OrderList orderList;

    public Table(int number) {
        this.number = number;
        this.isOrdering = false;
        this.orderList = new OrderList();
    }

    private void isOrdering(boolean isOrdering){
        this.isOrdering = isOrdering;
    }

    public int getNumber() {
        return number;
    }

    public boolean isOrdering() {
        return isOrdering;
    }

    public OrderList getOrderList() {
        return orderList;
    }
}
