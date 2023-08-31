package domain;

import constant.ExceptionMessage;

import java.util.HashMap;
import java.util.Map;

public class Table {

    private static final int DEFAULT = 0;
    private static final int MAX_ORDER_QUANTITY = 100;

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
        int newQuantity = order.get(menu) + quantity;
        validateQuantity(newQuantity);
        order.put(menu, newQuantity);
    }

    private void validateQuantity(int quantity) {
        if (quantity >= MAX_ORDER_QUANTITY) {
            throw new IllegalArgumentException(ExceptionMessage.ORDER_QUANTITY_EXCEEDED.toString());
        }
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }
}
