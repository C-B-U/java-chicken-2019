import constants.FunctionScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class FunctionScreenTest {
    @Test
    @DisplayName("화면에 기능 목록이 출력이 되는지 확인한다.")
    void showFunctionScreen(){
        String screen = FunctionScreen.showMainFunction();
        assertThat(screen).contains("1 - 주문등록\n" +
                "2 - 결제하기\n" +
                "3 - 프로그램 종료");
    }

    @Test
    @DisplayName("1번을 눌렀을 때 주문 등록 기능을 요청했는지 확인한다.")
    void requestRegisterOrder(){
        boolean isRegisterOrder = FunctionScreen.isRegisterOrder(1);
        assertThat(isRegisterOrder).isTrue();
    }

    @Test
    @DisplayName("2번을 눌렀을 때 결제 하기 기능을 요청했는지 확인한다.")
    void requestMakePayment(){
        boolean isMakePayment = FunctionScreen.isMakePayment(2);
        assertThat(isMakePayment).isTrue();
    }

    @Test
    @DisplayName("3번을 눌렀을 때 프로그램 종료 기능을 요청했는지 확인한다.")
    void requestProgramExit(){
        boolean isMakePayment = FunctionScreen.isNotProgramExit(3);
        assertThat(isMakePayment).isFalse();
    }
}
