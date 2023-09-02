package view;

import domain.Menu;
import domain.PosFeature;
import domain.ProcessMessage;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";

    public void printMainScreen() {
        System.out.println(ProcessMessage.MAIN_SCREEN);
        System.out.println(PosFeature.getFeatureName());
        printSelectFeature();
    }

    private void printSelectFeature() {
        printNewLine();
        System.out.println(ProcessMessage.SELECT_FEATURE);
    }

    public void printException(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printTables(List<Table> tables) {
        printNewLine();
        System.out.println(ProcessMessage.TABLE_LIST);
        printLine(TOP_LINE, tables.size());
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, tables.size());
        printSelectTable();
    }

    private void printSelectTable() {
        printNewLine();
        System.out.println(ProcessMessage.SELECT_TABLE);
    }

    private void printLine(String line, int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        printNewLine();
    }

    private void printTableNumbers(List<Table> tables) {
        for (Table table : tables) {
            System.out.printf(TABLE_FORMAT, table.getNumber());
        }
        printNewLine();
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printMenus() {
        printNewLine();
        System.out.println(Menu.getMenuBoard());
        printSelectMenu();
    }

    private void printSelectMenu() {
        printNewLine();
        System.out.println(ProcessMessage.SELECT_MENU);
    }
}
