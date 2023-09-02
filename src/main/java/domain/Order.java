package domain;

public class Order {
    private final Menu menu;
    private final MenuQuantity menuQuantity;
    private final int tableNumber;

    public Order(Menu menu, MenuQuantity menuQuantity, int tableNumber) {
        this.menu = menu;
        this.menuQuantity = menuQuantity;
        this.tableNumber = tableNumber;

    }
}
