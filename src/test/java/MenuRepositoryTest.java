import domain.MainOptions;
import domain.MenuRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class MenuRepositoryTest {

    @DisplayName("존재하는 메뉴일 경우 true를 반환한다.")
    @Test
    void isExist() {
        int input = 1;

        assertThat(MenuRepository.findMenuByNumber(input).getName()).isEqualTo("후라이드");
    }

    @DisplayName("존재하지 않는 메뉴일 경우 예외를 발생시킨다.")
    @Test
    void menuException() {
        int input = 12;

        assertThatThrownBy(() -> MainOptions.getMainOptions(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
