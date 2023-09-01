import domain.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TableRepositoryTest {

    @DisplayName("존재하지 않는 테이블을 입력할 경우 예외가 발생한다.")
    @Test
    void orderException() {
        int input = 100;

        assertThatThrownBy(() -> TableRepository.findByTableNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
