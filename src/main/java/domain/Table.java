package domain;

import constant.ExceptionMessage;
import constant.PrintElement;

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

    public int totalPrice() {
        return order.keySet()
                .stream()
                .filter(menu -> order.get(menu) != DEFAULT)
                .mapToInt(menu -> order.get(menu) * menu.getPrice())
                .sum();
    }

    public int discountChicken() {
        return order.keySet()
                .stream()
                .filter(Menu::isChicken)
                .mapToInt(order::get)
                .sum();
    }
    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public String printMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(PrintElement.HISTORY_CONFIG).append(PrintElement.NEW_LINE);
        appendMenu(stringBuilder);
        return stringBuilder.toString();
    }

    private void appendMenu(StringBuilder stringBuilder) {
        order.keySet()
                .stream()
                .filter(key -> order.get(key) != DEFAULT)
                .forEach(menu ->
                        stringBuilder.append(menu.getName())
                                .append(PrintElement.BLANK)
                                .append(order.get(menu))
                                .append(PrintElement.BLANK)
                                .append(menu.getPrice())
                                .append(PrintElement.NEW_LINE)
                );
    }
}
