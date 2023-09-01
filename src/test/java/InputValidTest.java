import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class InputValidTest {

    private static final String ERROR = "[ERROR]";

    @Test
    @DisplayName("메인 기능의 숫자가 1~3 사이의 숫자가 아니면 오류가 발생한다.")
    void validateMainListNumber(){
        assertThatThrownBy(() -> Main.validateMainListNumber(5))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }

    @Test
    @DisplayName("테이블 숫자가 옳지 않으면 오류가 발생한다.")
    void validateTableListNumber(){
        TableList tableList = new TableList();

        assertThatThrownBy(() -> tableList.validateTableNumber(7))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR);
    }
}
