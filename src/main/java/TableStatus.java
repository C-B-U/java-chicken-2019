import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableStatus {

    private static final List<String> upElement = List.of("┏", "-", "┓");
    private static final List<String> downElement = List.of("┗", "-" ,"┛");
    private static final List<String> downElementOrder = List.of("┗", "#" ,"┛");
    private final TableList tableList;
    private final Map<Table, List<String>> downSide = new HashMap<>(6);

    public TableStatus(TableList tableList) {
        this.tableList = tableList;
        initDownSide();
    }

    private void initDownSide() {
        List<Table> tables = tableList.getTables();
        for (Table table : tables){
            downSide.put(table, downElement);
        }
    }


    public void changeTableOrderStatus(Table table){
        downSide.put(table, downElementOrder);
    }

    public void changeTablePaymentStatus(Table table){
        downSide.put(table, downElement);
    }

    @Override
    public String toString() {
        List<Table> tables = tableList.getTables();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < tables.size(); i++){
            for (String upside : upElement){
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
        stringBuilder.append("\n");
        return stringBuilder.toString();
    }
}
