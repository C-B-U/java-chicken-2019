import java.util.EnumMap;
import java.util.Map;

public class OrderList {

    private final EnumMap<Menu, Long> menus = new EnumMap<>(Menu.class);

    public Map<Menu, Long> getMenus() {
        return menus;
    }

    // 결제 기능
}
