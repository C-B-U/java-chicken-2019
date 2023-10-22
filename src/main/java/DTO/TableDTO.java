package DTO;

import domain.TableList;
import domain.TableStatus;

public class TableDTO {
    private final TableList tableList;
    private final TableStatus tableStatus;

    public TableDTO() {
        this.tableList = new TableList();
        this.tableStatus = new TableStatus(tableList);
    }

    public TableList getTableList() {
        return tableList;
    }

    public TableStatus getTableStatus() {
        return tableStatus;
    }
}
