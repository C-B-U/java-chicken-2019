package controller;

import domain.*;
import view.InputView;
import view.OutputView;

public class ChickenController {

    public void start() {
        OutputView.printMainOption();
        while (true) {
            MainOptions option = InputView.inputMainOption();
            if (option.isTermination()) {
                break;
            }
            OutputView.printTables(TableRepository.tables());
            Table table = InputView.inputTableNumber();
            OutputView.printMenus(MenuRepository.menus());
            Menu menu = InputView.inputMenu();
        }
    }
}
