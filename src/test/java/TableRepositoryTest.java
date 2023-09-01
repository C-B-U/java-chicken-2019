import domain.Menu;
import domain.MenuRepository;
import domain.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TableRepositoryTest {

    @DisplayName("존재하지 않는 테이블을 입력할 경우 예외가 발생한다.")
    @Test
    void orderException() {
        int input = 100;

        assertThatThrownBy(() -> TableRepository.findByTableNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("테이블에 메뉴와 수량을 입력할 경우 주문 요청이 들어간다.")
    @Test
    void addMenu() {
        TableRepository tableRepository = new TableRepository();
        Menu menu = MenuRepository.findMenuByNumber(1);
        int quantity = 1;

        tableRepository.addMenu(1, menu, quantity);

        assertThat(TableRepository.tables().get(0).hasOrder()).isTrue();
    }
}
