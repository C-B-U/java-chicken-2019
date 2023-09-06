import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class PaymentTest {
    @Test
    @DisplayName("신용카드로 결제를 진행했을 때 금액을 확인한다.")
    void applyDiscountPayment(){
        OrderList orderList = new OrderList();
        orderList.saveOrder(Menu.MENU1, 1);

        Payment payment = new Payment(orderList);

        payment.applyDiscount(1);

        assertThat(payment.toString()).isEqualTo("16000원");
    }

    @Test
    @DisplayName("결제 수단이 화면에 보여지는지 확인한다.")
    void showPaymentScreen(){
        String screen = PaymentMethod.showPaymentMethod();
        assertThat(screen).isEqualTo("## 신용 카드는 1번, 현금는 2번");
    }

}
