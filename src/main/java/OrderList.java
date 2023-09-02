import java.util.EnumMap;
import java.util.Map;

public class OrderList {
    private static final int MAX_QUANTITY = 99;
    private static final int MIN_QUANTITY = 1;
    private static final int DEFAULT_QUANTITY = 0;
    private final EnumMap<Menu, Integer> menus = new EnumMap<>(Menu.class);

    public void saveOrder(Menu menu, int quantity){
        menus.put(menu, quantity);
    }

    public void validateMenuQuantity(Menu menu, int quantity){
        int sum = quantity + menus.getOrDefault(menu, DEFAULT_QUANTITY);
        if( quantity < MIN_QUANTITY || sum > MAX_QUANTITY){
            throw new IllegalArgumentException(String.format(ErrorMessage.INPUT_MENU_QUANTITY_ERROR.toString(), MAX_QUANTITY));
        }
    }

    public Map<Menu, Integer> getMenus() {
        return menus;
    }

    // 결제 기능
}
