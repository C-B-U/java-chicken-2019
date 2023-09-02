import java.util.*;

public class TableList {

    private final List<String> upSide = List.of("┏", "-", "┓");
    private final List<Table> tables;
    private final Map<Table, List<String>> downSide = new HashMap<>(6);


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
        downSide.put(table, List.of("┗", "-" ,"┛"));
    }


    public void changeTableOrderStatus(Table table){
        table.checkOrdering();
        if (table.isOrdering()){
            downSide.put(table, List.of("┗", "#" ,"┛"));
        }
    }

    public void changeTablePaymentStatus(Table table){
        downSide.put(table, List.of("┗", "-" ,"┛"));
    }

    public void validateTableNumber(Integer number){
        if(tables.stream().noneMatch(table -> table.getNumber() == number)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_TABLE_NUMBER_ERROR.toString());
        }
    }

    public Table getTable(Integer number) {
        return tables.stream()
                .filter(table -> table.getNumber() == number)
                .findFirst()
                .orElse(null);

    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tables.size(); i++){
            for (String upside : upSide){
                stringBuilder.append(upside).append(" ");
            }
        }
        stringBuilder.append("\n");

        for (Table table : tables){
            stringBuilder.append("| ").append(table.getNumber()).append(" | ");
        }
        stringBuilder.append("\n");

        for (Table table : tables){
            for (String downSide : downSide.get(table)){
                stringBuilder.append(downSide).append(" ");
            }
        }
        return stringBuilder.toString();
    }
}
