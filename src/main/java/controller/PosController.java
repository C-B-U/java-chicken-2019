package controller;

import view.InputView;
import view.OutputView;

public class PosController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();

    public void start() {
        while (true) {
            outputView.printMainScreen();
        }
    }
}
