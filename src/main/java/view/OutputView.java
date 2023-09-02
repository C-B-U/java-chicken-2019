package view;

import domain.*;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String BOTTOM_ORDER_LINE = "└ # ┘";
    private static final String WON_UNIT = "원";
    private static final String MENU_QUANTITY_PRICE = "메뉴 수량 금액";

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
        printTopLine(tables.size());
        printTableNumbers(tables);
        printBottomLine(tables);
        printSelectTable();
    }

    private void printBottomLine(List<Table> tables) {
        for (Table table : tables) {
            if (Orders.isIncludeNumber(table.getNumber())) {
                System.out.print(BOTTOM_ORDER_LINE);
                continue;
            }
            System.out.print(BOTTOM_LINE);
        }
        printNewLine();
    }

    private void printSelectTable() {
        printNewLine();
        System.out.println(ProcessMessage.SELECT_TABLE);
    }

    private void printTopLine(int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(TOP_LINE);
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

    public void printEnterQuantity() {
        printNewLine();
        System.out.println(ProcessMessage.ENTER_QUANTITY);
    }

    public void printOrderDetails(List<String> orders) {
        printNewLine();
        System.out.println(ProcessMessage.ORDER_DETAILS);
        System.out.println(MENU_QUANTITY_PRICE);
        orders.forEach(System.out::println);
    }

    public void printProceedPayment(int tableNumber) {
        printNewLine();
        System.out.println(String.format(ProcessMessage.PROCEED_PAYMENT.toString(), tableNumber));
        printSelectPaymentMethod();
    }

    private void printSelectPaymentMethod() {
        System.out.println(ProcessMessage.SELECT_PAYMENT_METHOD);
    }

    public void printFinalPaymentAmount(Double finalAmount) {
        printNewLine();
        System.out.println(ProcessMessage.FINAL_PAYMENT_AMOUNT);
        System.out.println(String.format("%.0f", finalAmount) + WON_UNIT);
    }
}
