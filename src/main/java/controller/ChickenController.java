package controller;

import domain.*;
import service.ChickenService;
import view.InputView;
import view.OutputView;

public class ChickenController {

    private final ChickenService service = new ChickenService();

    public void start() {
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
            OutputView.printTables(TableRepository.tables());
            int table = InputView.inputTableNumber();
            OutputView.printMenus(MenuRepository.menus());
            Menu menu = InputView.inputMenu();
            int quantity = InputView.inputQuantity();
            service.order(table, menu, quantity);
        }
    }

    private void payment(MainOptions options) {
        if (options.isPayment()) {
            OutputView.printTables(TableRepository.tables());
            Table table = service.findByTableNumber(InputView.inputTableNumber());
            OutputView.printOrderHistory(table);
            OutputView.printPayment(table);
            OutputView.printTotalPrice(service.payment(table, InputView.inputPayment()));
        }
    }
}
