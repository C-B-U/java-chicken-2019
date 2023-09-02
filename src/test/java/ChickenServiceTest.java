import constant.PaymentType;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import service.ChickenService;

import static org.assertj.core.api.Assertions.assertThat;

public class ChickenServiceTest {

    ChickenService service = new ChickenService();

    @DisplayName("테이블번호, 메뉴, 수량을 입력할 경우 주문 요청이 들어간다.")
    @Test
    void addMenu() {
        int tableNumber = 1;
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 1;

        service.order(tableNumber, menu, quantity);

        assertThat(TableRepository.tables().get(0).hasOrder()).isTrue();
    }

    @DisplayName("테이블에 메뉴와 수량을 입력할 경우 주문 요청이 들어간다.")
    @Test
    void pay() {
        int tableNumber = 1;
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 1;
        service.order(tableNumber, menu, quantity);

        service.payment(TableRepository.findByTableNumber(tableNumber), PaymentType.CARD);

        assertThat(TableRepository.findByTableNumber(tableNumber).hasOrder()).isFalse();
    }

    @DisplayName("테이블 번호를 입력하면 해당 번호를 가진 테이블을 반환한다.")
    @Test
    void findByTableNumber() {
        int tableNumber = 1;

        Table table = service.findByTableNumber(tableNumber);

        assertThat(table).isEqualTo(TableRepository.findByTableNumber(tableNumber));
    }
}
