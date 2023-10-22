package domain;

import constants.ErrorMessage;
import constants.Menu;
import constants.ProgressMessage;

import java.util.EnumMap;
import java.util.Map;

public class OrderList {
    private static final int MAX_QUANTITY = 99;
    private static final int MIN_QUANTITY = 1;
    private static final int DEFAULT_QUANTITY = 0;
    private final EnumMap<Menu, Integer> menus = new EnumMap<>(Menu.class);

    public void saveOrder(Menu menu, int quantity) {
        menus.put(menu, getTotalQuantity(menu, quantity));
    }

    public void validateMenuQuantity(Menu menu, int quantity) {
        if (quantity < MIN_QUANTITY || getTotalQuantity(menu, quantity) > MAX_QUANTITY) {
            throw new IllegalArgumentException(String.format(ErrorMessage.INPUT_MENU_QUANTITY_ERROR.toString(), MAX_QUANTITY));
        }
    }

    private int getTotalQuantity(Menu menu, int quantity) {
        return quantity + menus.getOrDefault(menu, DEFAULT_QUANTITY);
    }

    public void completePayment() {
        menus.clear();
    }

    public Map<Menu, Integer> getMenus() {
        return menus;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(ProgressMessage.ORDER_HISTORY).append("\n")
                .append(ProgressMessage.HISTORY_ELEMENT).append("\n");

        for (Map.Entry<Menu, Integer> entry : menus.entrySet()) {
            Menu menu = entry.getKey();
            int quantity = entry.getValue();
            int price = menu.getPrice();
            stringBuilder.append(menu.getName())
                    .append(" ")
                    .append(quantity)
                    .append(" ")
                    .append(price)
                    .append("\n");
        }
        return stringBuilder.toString();
    }
}
