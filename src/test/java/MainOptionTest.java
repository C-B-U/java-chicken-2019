import domain.MainOptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MainOptionTest {

    @DisplayName("1을 입력할 경우 ORDER_REGISTRATION을 반환한다.")
    @Test
    void getOrderRegistration() {
        int input = 1;

        MainOptions option = MainOptions.getMainOptions(input);

        assertThat(option).isEqualTo(MainOptions.ORDER_REGISTRATION);
    }

    @DisplayName("1을 입력할 경우 ORDER_REGISTRATION을 반환한다.")
    @Test
    void isOrder() {
        int input = 1;

        MainOptions option = MainOptions.getMainOptions(input);

        assertThat(option.isOrder()).isTrue();
    }

    @DisplayName("1을 입력할 경우 PAYMENT을 반환한다.")
    @Test
    void isPayment() {
        int input = 2;

        MainOptions option = MainOptions.getMainOptions(input);

        assertThat(option.isPayment()).isTrue();
    }

    @DisplayName("3을 입력할 경우 TERMINATION을 반환한다.")
    @Test
    void isTermination() {
        int input = 3;

        MainOptions option = MainOptions.getMainOptions(input);

        assertThat(option.isTermination()).isTrue();
    }

    @DisplayName("1, 2, 3 이외의 입력이 들어올 경우 예외가 발생한다.")
    @Test
    void exception() {
        int input = 4;

        assertThatThrownBy(() -> MainOptions.getMainOptions(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
