package view;


import camp.nextstep.edu.missionutils.Console;
import domain.*;
import validator.InputValidator;

public class InputView {
    private static final InputValidator inputValidator = new InputValidator();
    private static final OutputView outputView = new OutputView();

    public PosFeature inputWantedFeature() {
        String number = Console.readLine();
        try {
            return PosFeature.convert(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputWantedFeature();
        }
    }

    public int inputYourTable() {
        String number = Console.readLine();
        try {
            inputValidator.validateIsDigit(number);
            TableList.matchNumber(Integer.parseInt(number));
            return Integer.parseInt(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputYourTable();
        }
    }

    public Menu inputWantedMenu() {
        String number = Console.readLine();
        try {
            inputValidator.validateIsDigit(number);
            return Menu.convert(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputWantedMenu();
        }
    }

    public MenuQuantity inputMenuQuantity() {
        String quantity = Console.readLine();
        try {
            inputValidator.validateIsDigit(quantity);
            return new MenuQuantity(Integer.parseInt(quantity));
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputMenuQuantity();
        }
    }

    public PaymentMethod inputWantedPaymentMethod() {
        String number = Console.readLine();
        try {
            inputValidator.validateIsDigit(number);
            return PaymentMethod.convert(number);
        } catch (IllegalArgumentException e) {
            outputView.printException(e);
            return inputWantedPaymentMethod();
        }

    }
}
