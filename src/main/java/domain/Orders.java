package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Orders {
    private static final String BLANK = " ";
    private static List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public static boolean isIncludeNumber(int number) {
        return orders.stream()
                .anyMatch(order -> order.getTableNumber() == number);
    }

    public List<String> getOrder(int number) {
        List<Order> tableOrder = orders.stream()
                .filter(order -> order.getTableNumber() == number)
                .collect(Collectors.toList());
        return tableOrder.stream().map(this::convertString).collect(Collectors.toList());
    }

    public String convertString(Order order) {
        return order.getMenu() + BLANK + order.getMenuQuantity() + BLANK + order.getPrice();
    }
}
