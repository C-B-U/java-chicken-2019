import java.util.ArrayList;
import java.util.List;

public class TableList {
    private final List<Table> tables;

    public TableList() {
        this.tables = new ArrayList<>();
        addTableWithNumber(1);
        addTableWithNumber(2);
        addTableWithNumber(3);
        addTableWithNumber(5);
        addTableWithNumber(6);
        addTableWithNumber(8);
    }

    private void addTableWithNumber(int number) {
        Table table = new Table(number);
        tables.add(table);
    }

    public void validateTableNumber(Integer number) {
        if (tables.stream().noneMatch(table -> table.getNumber() == number)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_TABLE_NUMBER_ERROR.toString());
        }
    }

    public Table getTable(Integer number) {
        return tables.stream()
                .filter(table -> table.getNumber() == number)
                .findFirst()
                .orElse(null);
    }

    public List<Table> getTables() {
        return tables;
    }

}
