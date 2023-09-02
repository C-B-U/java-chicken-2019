package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class PosController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final TableList tableList = new TableList();
    private static final Orders orders = new Orders();

    public void start() {
        while (true) {
            outputView.printMainScreen();
            PosFeature feature = inputView.inputWantedFeature();
            if (feature == PosFeature.PROGRAM_QUIT) {
                break;
            }
            execute(feature);
        }
    }

    public void execute(PosFeature feature) {
        outputView.printTables(tableList.getTableList());
        int tableNumber = inputView.inputYourTable();
        if (feature == PosFeature.ORDER_REGISTER) {
            executeOrderRegister(tableNumber);
            return;
        }
        executePayment(tableNumber);
    }

    private void executeOrderRegister(int tableNumber) {
        outputView.printMenus();
        Menu menu = inputView.inputWantedMenu();
        outputView.printEnterQuantity();
        MenuQuantity quantity = inputView.inputMenuQuantity();
        orders.add(new Order(menu, quantity, tableNumber));
    }

    private void executePayment(int tableNumber) {
        outputView.printOrderDetails(orders.getOrder(tableNumber));
        outputView.printProceedPayment(tableNumber);
        inputView.inputWantedPaymentMethod();
    }
}
