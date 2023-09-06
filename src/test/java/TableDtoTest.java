import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TableDtoTest {

    @Test
    @DisplayName("초기화된 테이블들이 저장되는지 확인한다.")
    void saveInitTables(){
        TableList tableList = new TableList();
        List<Table> tables = tableList.getTables();

        List<Integer> tableNumbersToCheck = List.of(1,2,3,5,6,8);
        for (int i = 0; i < tableNumbersToCheck.size(); i++){
            Table table = tables.get(i);
            assertThat(table.getNumber()).isEqualTo(tableNumbersToCheck.get(i));
        }
    }
}
