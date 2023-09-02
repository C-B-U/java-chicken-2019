package domain;

import java.util.ArrayList;
import java.util.List;

public class TableList {
    private static final List<Integer> tableNumbers = List.of(1, 2, 3, 4, 5, 6, 8);
    private final List<Table> list = new ArrayList<>();

    public TableList() {
        tableNumbers.forEach(number -> list.add(new Table(number)));
    }

    public List<Table> getTableList() {
        return new ArrayList<>(list);
    }
}
