package controller;

import domain.MainOptions;
import view.InputView;
import view.OutputView;

public class ChickenController {

    public void start() {
        OutputView.printMainOption();
        MainOptions option = InputView.inputMainOption();
    }
}
