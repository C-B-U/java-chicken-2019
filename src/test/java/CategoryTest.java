import domain.Category;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CategoryTest {

    @DisplayName("카테고리가 Chicken일 경우 true를 반환한다.")
    @Test
    void isChicken() {
        Category category = Category.CHICKEN;
        assertThat(category.isChicken()).isTrue();
    }
}