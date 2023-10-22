import constants.Menu;
import domain.OrderList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class OrderListTest {
    @Test
    @DisplayName("치킨을 1마리 시켰을 때 주문이 등록되는지 확인한다.")
    void RegisterOrder(){
        OrderList orderList = new OrderList();
        orderList.saveOrder(Menu.MENU1, 1);

        Map<Menu, Integer> menus = orderList.getMenus();
        int quantity = menus.get(Menu.MENU1);

        assertThat(quantity).isEqualTo(1);
    }
}
