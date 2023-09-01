import java.util.*;

public class TableList {

    private final List<String> upSide = List.of("┏", "-", "┓");
    private final List<Table> tables;
    private final Map<Table, List<String>> downSide = new HashMap<>(6);


    public TableList() {
        this.tables = new ArrayList<>(6);
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
        downSide.put(table, List.of("┗", "-" ,"┛"));
    }


    public void changeTableStatus(Table table){
        if (table.isOrdering()){
            downSide.put(table, List.of("┗", "#" ,"┛"));
        }
    }

    public void validateTableNumber(Integer number){
        if(tables.stream().noneMatch(table -> table.getNumber() == number)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_TABLE_NUMBER_ERROR.toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Table table : tables){
            stringBuilder.append(upSide);
            stringBuilder.append("\n");
            stringBuilder.append("| ").append(table.getNumber()).append(" |");
            stringBuilder.append("\n");
            stringBuilder.append(downSide.get(table));
        }
        return stringBuilder.toString();
    }
}
