import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class MenuTest {

    @Test
    @DisplayName("메뉴 화면을 보여주는지 확인한다.")
    void showMenuScreen(){
        String screen = Menu.showMenu();
        assertThat(screen).contains("[치킨] 1 - 후라이드 : 16000원\n" +
                "[치킨] 2 - 양념치킨 : 16000원\n" +
                "[치킨] 3 - 반반치킨 : 16000원\n" +
                "[치킨] 4 - 통구이 : 16000원\n" +
                "[치킨] 5 - 간장치킨 : 17000원\n" +
                "[치킨] 6 - 순살치킨 : 17000원\n" +
                "[음료] 21 - 콜라 : 1000원\n" +
                "[음료] 22 - 사이다 : 1000원");
    }

    @Test
    @DisplayName("번호에 맞는 메뉴를 반환하는지 확인한다.")
    void getMenuByMenuId(){
        Menu menu = Menu.getMenu(1);
        assertThat(menu).isEqualTo(Menu.MENU1);
    }

}
