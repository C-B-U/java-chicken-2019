package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private static final String BLANK = " ";
    private static final List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public static boolean isIncludeNumber(int number) {
        return orders.stream()
                .anyMatch(order -> order.getTableNumber() == number);
    }

    public List<String> getSpecificTableOrderDetails(int number) {
        List<Order> tableOrder = getSpecificTableOrder(number);
        return tableOrder.stream().map(this::convertString).collect(Collectors.toList());
    }

    public List<Order> getSpecificTableOrder(int number) {
        return orders.stream()
                .filter(order -> order.getTableNumber() == number)
                .collect(Collectors.toList());
    }

    public String convertString(Order order) {
        return order.getMenuName() + BLANK + order.getMenuQuantity() + BLANK + order.getPrice();
    }

    public void deleteOrder(int tableNumber) {
        orders.stream()
                .filter(order -> order.getTableNumber() == tableNumber)
                .collect(Collectors.toList())
                .forEach(orders::remove);
    }
}
