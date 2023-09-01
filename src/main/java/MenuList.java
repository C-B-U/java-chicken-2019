import java.util.ArrayList;
import java.util.List;

public class MenuList {

    private final List<Menu> menus;

    public MenuList() {
        this.menus = new ArrayList<>(8);
        Menu.addMenu(menus);
    }


}
