import constant.PaymentType;
import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TableTest {

    @DisplayName("테이블에 메뉴와 수량을 입력할 경우 주문 요청이 들어간다.")
    @Test
    void addMenu() {
        Table table = new Table(10);
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 1;

        table.addMenu(menu, quantity);

        assertThat(table.hasOrder()).isTrue();
    }

    @DisplayName("결제를 요청할 경우 할인가를 반영한 총 금액을 반환한다.")
    @Test
    void payment() {
        Table table = new Table(10);
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 3;
        table.addMenu(menu, quantity);

        int price = table.payment(PaymentType.getPaymentType(1));

        assertThat(price).isEqualTo(48000);
    }

    @DisplayName("현금으로 결제할 경우 5%가 할인된다.")
    @Test
    void paymentCash() {
        Table table = new Table(10);
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 3;
        table.addMenu(menu, quantity);

        int price = table.payment(PaymentType.CASH);

        assertThat(price).isEqualTo(45600);
    }

    @DisplayName("치킨 10마리당 10,000씩 할인한다.")
    @Test
    void paymentChicken() {
        Table table = new Table(10);
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 10;
        table.addMenu(menu, quantity);

        int price = table.payment(PaymentType.CARD);

        assertThat(price).isEqualTo(150000);
    }

    @DisplayName("치킨 10마리를 시키고 현금결제를 할 경우 중첩 할인이 가능하다.")
    @Test
    void overlappingDiscount() {
        Table table = new Table(10);
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 10;
        table.addMenu(menu, quantity);

        int price = table.payment(PaymentType.CASH);

        assertThat(price).isEqualTo(142500);
    }
}
