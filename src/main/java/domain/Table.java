package domain;

import java.util.HashMap;
import java.util.Map;

public class Table {

    private static final int DEFAULT = 0;

    private final int number;
    private final Map<Menu, Integer> order;

    public Table(final int number) {
        this.number = number;
        this.order = new HashMap<>();
        MenuRepository.menus()
                .forEach(menu -> order.put(menu, DEFAULT));
    }

    public boolean isExist(int number) {
        return number == this.number;
    }

    public void addMenu(Menu menu, int quantity) {
        int existingQuantity = order.get(menu);
        order.put(menu, existingQuantity += quantity);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
