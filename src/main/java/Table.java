public class Table {

    private final int number;
    private boolean isOrdering;
    private final OrderList orderList;

    public Table(int number) {
        this.number = number;
        this.isOrdering = false;
        this.orderList = new OrderList();
    }

    public void checkOrdering(){
        this.isOrdering = true;
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
