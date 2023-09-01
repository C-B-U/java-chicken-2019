package controller;

import domain.*;
import service.ChickenService;
import view.InputView;
import view.OutputView;

public class ChickenController {

    private final ChickenService service = new ChickenService();

    public void run() {
        try {
            startSelling();
        } catch (IllegalArgumentException exception) {
            OutputView.printExceptionMessage(exception.getMessage());
        }
    }

    private void startSelling() {
        while (true) {
            OutputView.printMainOption();
            MainOptions option = InputView.inputMainOption();
            if (option.isTermination()) {
                break;
            }
            orderMenu(option);
            payment(option);
        }
    }

    private void orderMenu(MainOptions options) {
        if (options.isOrder()) {
            int tableNumber = findTable();
            OutputView.printMenus(MenuRepository.menus());
            Menu menu = InputView.inputMenu();
            int quantity = InputView.inputQuantity();
            service.order(tableNumber, menu, quantity);
        }
    }

    private void payment(MainOptions options) {
        if (options.isPayment()) {
            Table table = service.findByTableNumber(findTable());
            OutputView.printOrderHistory(table);
            OutputView.printPayment(table);
            OutputView.printTotalPrice(service.payment(table, InputView.inputPayment()));
        }
    }

    private int findTable() {
        OutputView.printTables(TableRepository.tables());
        return InputView.inputTableNumber();
    }
}
