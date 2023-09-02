package controller;

import domain.PosFeature;
import view.InputView;
import view.OutputView;

public class PosController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

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
        if (feature == PosFeature.ORDER_REGISTER) {
            executeOrderRegister();
            return;
        }
        executePayment();
    }

    private void executeOrderRegister() {
    }


    private void executePayment() {
    }
}
