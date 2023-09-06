import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class TableDtoTest {

    TableList tableList = new TableList();

    @Test
    @DisplayName("초기화된 테이블들이 저장되는지 확인한다.")
    void saveInitTables(){
        List<Table> tables = tableList.getTables();

        List<Integer> tableNumbersToCheck = List.of(1,2,3,5,6,8);
        for (int i = 0; i < tableNumbersToCheck.size(); i++){
            Table table = tables.get(i);
            assertThat(table.getNumber()).isEqualTo(tableNumbersToCheck.get(i));
        }
    }

    @Test
    @DisplayName("테이블 번호와 일치하는 테이블을 반환한다.")
    void getTableByTableId(){
        Table table = tableList.getTable(1);
        assertThat(table.getNumber()).isEqualTo(1);
    }
}
