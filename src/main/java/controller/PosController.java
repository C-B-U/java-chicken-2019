package controller;

import constants.FunctionScreen;
import constants.Menu;
import domain.Payment;
import domain.Table;
import service.PosService;
import view.InputView;
import view.OutputView;

public class PosController {
    private static final int INIT_NUMBER = 0;
    private final PosService posService;
    private final InputView inputView;
    private final OutputView outputView;

    public PosController() {
        this.posService = new PosService();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startProgram() {
        int number = INIT_NUMBER;
        while (FunctionScreen.isNotProgramExit(number)) {
            number = selectMain();
            executeFunction(number);
        }
    }

    private int selectMain() {
        outputView.printMainProgram();
        outputView.printMainFunction();
        return inputView.readMainNumber();
    }

    private void executeFunction(int number) {
        registerOrder(number);
        makePayment(number);
    }

    public void registerOrder(int number) {
        if (FunctionScreen.isRegisterOrder(number)) {
            outputView.printTableStatus(posService.getTableStatus());
            Table table = inputView.readTableNumber(posService.getTableList());

            outputView.printMenuList();
            Menu menu = inputView.readMenuNumber();

            int quantity = inputView.readMenuQuantity(table.getOrderList(), menu);

            posService.saveOrderList(table, menu, quantity);
            posService.updateTableOrderStatus(table);
        }
    }

    public void makePayment(int number) {
        if (FunctionScreen.isMakePayment(number)) {
            outputView.printTableStatus(posService.getTableStatus());
            Table table = inputView.readTableNumber(posService.getTableList());

            outputView.printOrderHistory(table.getOrderList());
            int paymentNumber = inputView.readPaymentNumber(table.getNumber());

            outputView.printPaymentAmount();
            Payment payment = posService.applyDiscount(table, paymentNumber);

            outputView.printPaymentPrice(payment);
            posService.updateTablePaymentStatus(table);
        }
    }
}
