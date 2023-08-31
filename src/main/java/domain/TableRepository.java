package domain;

import constant.ExceptionMessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static Table findByTableNumber(int number) {
        return tables.stream()
                .filter((table) -> table.isExist(number))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.NOT_EXIST_TABLE.toString()));
    }

    public void addMenu(int number, Menu menu, int quantity) {
        Table table = findByTableNumber(number);
        table.addMenu(menu, quantity);
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }
}
