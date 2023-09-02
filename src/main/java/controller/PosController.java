package controller;

import domain.PosFeature;
import domain.TableList;
import view.InputView;
import view.OutputView;

public class PosController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final TableList tableList = new TableList();

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
        executePayment();
    }

    private void executeOrderRegister(int tableNumber) {
        outputView.printMenus();
        inputView.inputWantedMenu();
    }


    private void executePayment() {
    }
}
