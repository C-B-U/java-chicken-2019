import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InputValidTest {

    private static final String ERROR = "[ERROR]";

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("메인 기능의 숫자가 1~3 사이의 숫자가 아니면 오류가 발생한다.")
    void validateMainListNumber(){
        assertThatThrownBy(() -> inputValidator.validateMainListNumber(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
