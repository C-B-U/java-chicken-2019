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
        if (feature == PosFeature.ORDER_REGISTER) {
            executeOrderRegister();
            return;
        }
        executePayment();
    }

    private void executeOrderRegister() {
        inputView.inputYourTable();
    }


    private void executePayment() {
    }
}
