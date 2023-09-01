import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import validator.InputValidator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    @DisplayName("문자를 입력할 경우 예외를 발생시킨다.")
    @Test
    void isExist() {
        String input = "hi";

        assertThatThrownBy(() -> InputValidator.validateNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
