package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private static List<Order> orders = new ArrayList<>();

    public void add(Order order) {
        orders.add(order);
    }

    public static boolean isIncludeNumber(int number) {
        return orders.stream()
                .anyMatch(order -> order.getTableNumber() == number);
    }
}
